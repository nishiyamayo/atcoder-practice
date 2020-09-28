import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

R, C, K = map(int, input().split())
B = [[0] * (C + 1) for _ in range(R + 1)]

for i in range(K):
    r, c, v = map(int, input().split())
    B[r][c] = v

dp = [[[0] * 4 for _ in range(C + 1)] for _ in range(R + 1)]

for r in range(1, R + 1):
    for c in range(1, C + 1):
        dp[r][c][0] = max(dp[r - 1][c])
        dp[r][c][0] = max(dp[r][c][0], dp[r][c - 1][0])
        dp[r][c][1] = max(dp[r - 1][c]) + B[r][c]
        dp[r][c][1] = max(dp[r][c][1], dp[r][c - 1][1], dp[r][c - 1][0] + B[r][c])
        dp[r][c][2] = max(dp[r][c - 1][2], dp[r][c - 1][1] + B[r][c])
        dp[r][c][3] = max(dp[r][c - 1][3], dp[r][c - 1][2] + B[r][c])

print(max(dp[R][C]))

#
#  3  1  4  2  0
#  0  0  0 20  0
