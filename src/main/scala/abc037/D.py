import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H, W = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(H)]

ts = []
for i in range(H):
    for j in range(W):
        ts.append((j, i, A[i][j]))

ts.sort(key=lambda t:t[2])

dp = [[0] * W for _ in range(H)]

ans = 0
MOD = int(1e9) + 7
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]
for t in ts:
    ans = (ans + dp[t[1]][t[0]]) % MOD

    for x, y in zip(dx, dy):
        if t[0] + x < 0 or t[0] + x >= W or t[1] + y < 0 or t[1] + y >= H or A[t[1]][t[0]] >= A[t[1] + y][t[0] + x]:
            continue
        dp[t[1] + y][t[0] + x] = (dp[t[1] + y][t[0] + x] + dp[t[1]][t[0]] + 1) % MOD

print((ans + W * H) % MOD)