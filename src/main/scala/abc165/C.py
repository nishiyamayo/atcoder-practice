import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M, Q = map(int, input().split())
A, B, C, D = [0] * Q, [0] * Q, [0] * Q, [0] * Q
for i in range(Q):
    A[i], B[i], C[i], D[i] = map(int, input().split())
    A[i] -= 1
    B[i] -= 1


def calc(X):
    score = 0
    for i in range(Q):
        if X[B[i]] - X[A[i]] == C[i]:
            score += D[i]

    return score


def solve(idx, par, X):
    if idx == N:
        return calc(X)

    ret = 0
    for i in range(par, M + 1):
        X[idx] = i
        ret = max(ret, solve(idx + 1, i, X))

    return ret


print(solve(0, 1, [0] * N))