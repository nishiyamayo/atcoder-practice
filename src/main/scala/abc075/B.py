import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H, W = map(int, input().split())
S = [list(input()) for _ in range(H)]

ans = [[0] * W for _ in range(H)]

dx = [-1, 0, 1, 1, 1, 0, -1, -1]
dy = [-1, -1, -1, 0, 1, 1, 1, 0]
for h in range(H):
    for w in range(W):
        if S[h][w] == '#':
            continue
        cnt = 0
        for nx, ny in zip(dx, dy):
            x, y = w + nx, h + ny
            if x < 0 or x >= W or y < 0 or y >= H:
                continue
            if S[y][x] == '#':
                cnt += 1
        S[h][w] = str(cnt)

[print("".join(S[i])) for i in range(H)]