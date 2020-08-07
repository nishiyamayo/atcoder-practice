import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
X, Y, P = [[0] * N for _ in range(3)]

for i in range(N):
    X[i], Y[i], P[i] = map(int, input().split())

V = [[0] * N for _ in range(1 << N)]
H = [[0] * N for _ in range(1 << N)]

for i in range(1 << N):
    vs, hs = 0, 0
    for j in range(N):
        v = abs(X[j] * P[j])
        h = abs(Y[j] * P[j])
        for k in range(N):
            if ((i >> k) & 1) == 1:
                v = min(v, abs(X[k] - X[j]) * P[j])
                h = min(h, abs(Y[k] - Y[j]) * P[j])
        V[i][j] = v
        H[i][j] = h


def calc(X, Y):

    ret = 0
    for i in range(N):
        ret += min(V[X][i], H[Y][i])

    return ret


ans = [1 << 60] * (N + 1)


def solve(idx, X, Y):
    if idx == N:
        pc = bin(X).count("1") + bin(Y).count("1")
        ans[pc] = min(ans[pc], calc(X, Y))
        return

    solve(idx + 1, X, Y)
    solve(idx + 1, X | (1 << idx), Y)
    solve(idx + 1, X, Y | (1 << idx))


solve(0, 0, 0)

for i in range(N + 1):
    print(ans[i])