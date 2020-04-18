import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, H = map(int, input().split())
A, B, C, D, E = map(int, input().split())


def ok(X):
    for i in range(0, N + 1):
        spend = i * A
        happy = i * B + H

        remain = X - spend

        if remain < 0:
            break

        cnt = min(N - i, remain // C)

        if happy + D * cnt > E * (N - cnt - i):
            return True

    return False


def solve():
    l, r = -1, 100 * 1000 * 1000 * 1000 * 1000 * 1000

    while l + 1 < r:
        c = (l + r) // 2
        if ok(c):
            r = c
        else:
            l = c

    return r

print(solve())