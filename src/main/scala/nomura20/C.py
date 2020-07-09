import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

minN, maxN = A[N], A[N]

mins = [0] * (N + 1)
maxs = [0] * (N + 1)


mins[N], maxs[N] = A[N], A[N]
for i in range(N - 1, -1, -1):
    mins[i] = (mins[i + 1] + 1) // 2 + A[i]
    maxs[i] = maxs[i + 1] + A[i]

# print(mins, maxs)


def ok():
    c = 1
    ret = 0
    for i in range(N + 1):
        if not mins[i] <= c:
            return -1
        c = min(c, maxs[i])
        ret += c
        # print(i, c)
        c = 2 * (c - A[i])

    return ret

print(ok())