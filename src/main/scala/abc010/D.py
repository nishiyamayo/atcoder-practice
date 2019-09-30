

class Edges(set):
    def __init__(self):
        set.__init__(self)


N, G, E = map(int, input().split())
P = list(map(int, input().split()))


def dfs(start: int, end: int, visited, g, path):

    path.append(start)
    visited[start] = True
    if start == end:
        return True

    for nx in g[start]:
        if visited[nx]:
            continue
        if dfs(nx, end, visited, g, path):
            return True

    del path[-1]
    return False


def rev(g, path):

    l = len(path)
    for i in range(l - 1):
        t, f = path[i], path[i + 1]
        g[t].remove(f)
        g[f].add(t)


graph = [Edges() for _ in range(N + 1)]

for p in P:
    graph[p].add(N)

for _ in range(E):
    a, b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)

path = []

cnt = 0
while dfs(0, N, [False for _ in range(N + 1)], graph, path):
    rev(graph, path)
    path = []
    cnt += 1

print(cnt)
