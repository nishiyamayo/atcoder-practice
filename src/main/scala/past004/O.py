from heapq import heappush, heappop
from typing import List, Tuple

N, M = map(int, input().split())
A = list(map(int, input().split()))

G: List[List[Tuple[int, int]]] = [[] for _ in range(N + 1)]

for idx, a in enumerate(A):
    G[idx].append((idx + 1, a))
    G[idx + 1].append((idx, 0))

for i in range(M):
    L, R, C = map(int, input().split())
    G[L - 1].append((R, C))

INF = 1 << 60


def dijkstra(s, g=None):
    d = [INF] * (N + 1)
    d[s] = 0
    q = []
    heappush(q, (0, s))

    while q:
        cost, cur = heappop(q)
        if d[cur] != cost:
            continue

        if g and cur == g:
            return cost

        for nx, c in G[cur]:
            if d[nx] > cost + c:
                d[nx] = cost + c
                heappush(q, (cost + c, nx))

    return -1


print(sum(A) - dijkstra(0, N))
