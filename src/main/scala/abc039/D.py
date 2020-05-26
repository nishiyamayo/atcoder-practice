import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H, W = map(int, input().split())

M = [["#"] * (W + 2)] + [["#"] + list(input()) + ["#"] for _ in range(H)] + [["#"] * (W + 2)]

dx, dy = [0, -1, 0, 1, 1, 1, 0, -1, -1], [0, -1, -1, -1, 0, 1, 1, 1, 0]

P = [["."] * (W + 2) for _ in range(H + 2)]

for h in range(1, H + 1):
    for w in range(1, W + 1):
        ok = True
        for i in range(9):
            ok &= M[h + dy[i]][w + dx[i]] == "#"
        P[h][w] = "#" if ok else "."


C = [["#"] * (W + 2) for _ in range(H + 2)]

for h in range(1, H + 1):
    for w in range(1, W + 1):
        ok = False
        for i in range(9):
            ok |= P[h + dy[i]][w + dx[i]] == "#"
        C[h][w] = "#" if ok else "."


pos = True
for h in range(1, H + 1):
    for w in range(1, W + 1):
        ok = False
        pos &= M[h][w] == C[h][w]

if pos:
    print("possible")
    for h in range(1, H + 1):
        print("".join(P[h][1:-1]))
else:
    print("impossible")