import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

MOD = int(1e9) + 7

dp = [[0] * 4 for _ in range(N + 1)]
dp[0][0] = 1
for i in range(1, N + 1):
    # 0も9もない
    dp[i][0] = dp[i - 1][0] * 8 % MOD
    # 0だけある
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] * 9) % MOD
    # 9だけある
    dp[i][2] = (dp[i - 1][0] + dp[i - 1][2] * 9) % MOD
    # 0も9もある
    dp[i][3] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] * 10) % MOD

print(dp[N][3])