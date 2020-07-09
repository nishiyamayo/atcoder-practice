import collections
import queue
import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())
X, Y = [0] * M, [0] * M
g = [[] for _ in range(N)]

for i in range(M):
    X[i], Y[i] = map(int, input().split())

    X[i] -= 1
    Y[i] -= 1
    g[X[i]].append(Y[i])
    g[Y[i]].append(X[i])


def bfs(x, y):
    visited = [False] * N
    q = queue.Queue()
    for nx in g[x]:
        if nx == y:
            continue
        q.put(nx)
        visited[nx] = True

    visited[x] = True

    while not q.empty():
        cur = q.get()
        if cur == y:
            return True

        for nx in g[cur]:
            if visited[nx]:
                continue
            q.put(nx)
            visited[nx] = True

    return False


cnt = 0
for i in range(M):
    if not bfs(X[i], Y[i]):
        cnt += 1

print(cnt)