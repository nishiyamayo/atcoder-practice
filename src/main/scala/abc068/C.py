import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())
f = [False] * N
s = [False] * N
for i in range(M):
    a, b = map(int, input().split())
    a, b = a - 1, b - 1

    if a == 0:
        f[b] = True
    if b == N -1:
        s[a] = True

ok = False
for i in range(N):
    if f[i] & s[i]:
        ok = True

print("POSSIBLE" if ok else "IMPOSSIBLE")