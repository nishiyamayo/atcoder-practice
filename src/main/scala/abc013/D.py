import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M, D = map(int, input().split())
A = list(map(int, input().split()))
T = [[0] * N for _ in range(35)]
INV = [i for i in range(N)]

for a in A:
    INV[a - 1], INV[a] = INV[a], INV[a - 1]
10
for i in range(N):
    T[0][INV[i]] = i


for i in range(1, 35):
    for k in range(N):
        T[i][k] = T[i - 1][T[i - 1][k]]

def solve(i):
    st = i
    for j in range(35):
        if (D >> j) & 1:
            st = T[j][st]
    print(st + 1)

for i in range(N):
    solve(i)