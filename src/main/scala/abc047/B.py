import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

W, H, N = map(int, input().split())

b = [[False] * W for _ in range(H)]

for i in range(N):
    X, Y, A = map(int, input().split())

    h0, h1, w0, w1 = -1, -1, -1, -1
    if A == 1:
        h0, h1, w0, w1 = 0, H, 0, X
    elif A == 2:
        h0, h1, w0, w1 = 0, H, X, W
    elif A == 3:
        h0, h1, w0, w1 = 0, Y, 0, W
    else:
        h0, h1, w0, w1 = Y, H, 0, W

    for x in range(w0, w1):
        for y in range(h0, h1):
            b[y][x] = True

cnt = 0
for y in range(H):
    for x in range(W):
        if not b[y][x]:
            cnt += 1

print(cnt)