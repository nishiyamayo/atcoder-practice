

from heapq import heappush, heappop

class Edge:
    def __init__(self, to: int, cost: int):
        self._to = to
        self._cost = cost

    @property
    def to(self):
        return self._to

    @property
    def cost(self):
        return self._cost

class Edges(list):
    def __init__(self):
        list.__init__(self)


INF = 1 << 40


def dijkstra(graph, ar, s: int):
    n = len(graph)
    dist = [INF] * n
    ta = [0] * n

    pq = []
    heappush(pq, (0, s))
    dist[s] = 0
    ta[s] = ar[s]


    while pq:
        (cost, cur) = heappop(pq)

        if dist[cur] != cost:
            continue

        for next in graph[cur]:
            if dist[next.to] > cost + next.cost:
                heappush(pq, (cost + next.cost, next.to))
                dist[next.to] = cost + next.cost
                ta[next.to] = max(ta[cur], ar[next.to])

    return dist, ta

# 参考: https://qiita.com/y-tsutsu/items/aa7e8e809d6ac167d6a1


# 入力を受け取る
n, m, t = map(int, input().split())

ar = list(map(int, input().split()))

g = [Edges() for _ in range(n)]
rg = [Edges() for _ in range(n)]
for _ in range(m):
    a, b, c = map(int, input().split())
    g[a - 1].append(Edge(b - 1, c))
    rg[b - 1].append(Edge(a - 1, c))

d1, c1 = dijkstra(g, ar, 0)
d2, c2 = dijkstra(rg, ar, 0)

ans = 0
for d1v, d2v, c1v, c2v in zip(d1, d2, c1, c2):
    if d1v + d2v > t:
        continue
    ans = max(ans, (t - d1v - d2v) * max(c1v, c2v))

print(ans)
