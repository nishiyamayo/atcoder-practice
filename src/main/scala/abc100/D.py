import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())
X, Y, Z = [0] * N, [0] * N, [0] * N

for i in range(N):
    X[i], Y[i], Z[i] = map(int, input().split())

codes = [[1, 1, 1], [1, 1, -1], [1, -1, 1], [1, -1, -1], [-1, 1, 1], [-1, 1, -1], [-1, -1, 1], [-1, -1, -1]]


def calc(code, idx):
    return code[0] * X[idx] + code[1] * Y[idx] + code[2] * Z[idx]


INF = 1 << 60
ans = -INF
for code in codes:
    ar = [0] * N

    for i in range(N):
        ar[i] = calc(code, i)

    ar.sort(reverse=True)

    ans = max(ans, sum(ar[:M]))

print(ans)