import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
X, Y, H = [0] * N, [0] * N, [0] * N

notzero = -1
for i in range(N):
    X[i], Y[i], H[i] = map(int, input().split())
    if H[i] != 0:
        notzero = i

def solve():
    for x in range(101):
        for y in range(101):
            cx, cy = x, y
            h = H[notzero] + abs(X[notzero] - cx) + abs(Y[notzero] - cy)
            ok = True
            for i in range(N):
                ok &= max(0, h - abs(X[i] - cx) - abs(Y[i] - cy)) == H[i]
            if ok:
                return cx, cy, h

print(*solve())