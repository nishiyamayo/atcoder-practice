import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())
ABC = [list(map(int, input().split())) for _ in range(M)]

INF = 1 << 28
ds = [[INF] * (N + 1) for _ in range(N + 1)]
for i in range(N + 1):
    ds[i][i] = 0

for abc in ABC:

    ds[abc[0]][abc[1]] = ds[abc[1]][abc[0]] = min(ds[abc[0]][abc[1]], abc[2])

for k in range(N + 1):
    for i in range(N + 1):
        for j in range(N + 1):
            ds[i][j] = ds[j][i] = min(ds[i][j], ds[i][k] + ds[k][j])
cnt = 0
for abc in ABC:
    used = False
    for i in range(N + 1):
        for j in range(N + 1):
            if ds[i][j] == ds[i][abc[0]] + abc[2] + ds[abc[1]][j]:
                used = True
    if not used:
        cnt += 1

print(cnt)
