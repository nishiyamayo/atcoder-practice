import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, C, D, E, F = map(int, input().split())

dp = [-1] * (F + 1)
dp[0] = 0

cnt = 1
for i in range(F + 1):
    if dp[i] >= 0 and i + A * 100 <= F:
        dp[i + A * 100] = max(dp[i + A * 100], dp[i])
    if dp[i] >= 0 and i + B * 100 <= F:
        dp[i + B * 100] = max(dp[i + B * 100], dp[i])
    if dp[i] >= 0 and i + C <= F and (dp[i] + C) * (100 + E) <= (i + C) * E:
        dp[i + C] = max(dp[i + C], dp[i] + C)
    if dp[i] >= 0 and i + D <= F and (dp[i] + D) * (100 + E) <= (i + D) * E:
        dp[i + D] = max(dp[i + D], dp[i] + D)

x, y = A * 100, 0
for i in range(F + 1):
    if x <= 0 or x * dp[i] > y * i:
        x, y = i, dp[i]

print(x, y)