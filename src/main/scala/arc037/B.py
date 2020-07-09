import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
from typing import List

sys.setrecursionlimit(10000000)

N, M = map(int, input().split())
g: List[List[int]] = [[] for _ in range(N)]

for i in range(M):
    a, b = map(int, input().split())
    a, b = a - 1, b - 1

    g[a].append(b)
    g[b].append(a)


def dfs(cur: int, par: int, visited: List[bool]) -> bool:
    visited[cur] = True

    for nx in g[cur]:
        if nx == par:
            continue
        if visited[nx]:
            return True
        if dfs(nx, cur, visited):
            return True

    return False


cnt = 0
visited = [False] * N
for i in range(N):
    if not visited[i]:
        cnt += 1 if not dfs(i, -1, visited) else 0

print(cnt)
