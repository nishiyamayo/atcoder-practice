import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())
WS = [[0, 0]] * N

for i in range(N):
    w, p = map(int, input().split())
    WS[i] = [w, p]


def ok(X):

    WS.sort(key=lambda x: x[0] * (x[1] - X), reverse=True)

    a = 0
    s = 0
    for i in range(K):
        a += WS[i][0] * WS[i][1] / 100
        s += WS[i][0]

    return a / s <= X / 100


def solve():
    l, r = 0, 100.0

    for _ in range(100):
        c = (l + r) / 2
        if ok(c):
            r = c
        else:
            l = c

    return r



print(solve())