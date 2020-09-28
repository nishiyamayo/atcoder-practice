import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H, W, M = map(int, input().split())
P = [list(map(int, input().split())) for _ in range(M)]

Xs = [0] * (W + 1)
Ys = [0] * (H + 1)
s = set()

for p in P:
    Xs[p[1]] += 1
    Ys[p[0]] += 1
    s.add((p[1], p[0]))

xmax = max(Xs)
ymax = max(Ys)

XMs = []
YMs = []
for i in range(W + 1):
    if Xs[i] == xmax:
        XMs.append(i)

for i in range(H + 1):
    if Ys[i] == ymax:
        YMs.append(i)


def ans():
    for x in XMs:
        for y in YMs:
            if (x, y) not in s:
                return xmax + ymax

    return xmax + ymax - 1


if len(XMs) * len(YMs) > M:
    print(xmax + ymax)
else:
    print(ans())
