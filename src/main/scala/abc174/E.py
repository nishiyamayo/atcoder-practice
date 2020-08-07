import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())

A = list(map(int, input().split()))


def ok(X):
    cnt = 0
    for a in A:
        cnt += (a - 1) // X

    return cnt <= K


def solve():
    l, r = 0, 1000000000

    while l + 1 < r:
        c = (l + r) // 2
        if ok(c):
            r = c
        else:
            l = c

    return r


print(solve())
