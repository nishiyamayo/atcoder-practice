import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

ans = 0
visited = [False] * (N + 1)

for i in range(N - 1):
    u, v = map(int, input().split())
    if u > v:
        u, v = v, u
    if not visited[u]:
        ans += u * (N - u + 1)
        visited[u] = True
    if not visited[v]:
        ans += v * (N - v + 1)
        visited[v] = True
    ans -= u * (N - v + 1)

print(ans if N != 1 else 1)