import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

dp = [N] * (N + 1)
dp[0] = 0
for i in range(N):
    dp[i + 1] = min(dp[i + 1], dp[i] + 1)
    six = 6
    nine = 9
    for p in range(10):
        if i + six <= N:
            dp[i + six] = min(dp[i + six], dp[i] + 1)
        if i + nine <= N:
            dp[i + nine] = min(dp[i + nine], dp[i] + 1)
        six *= 6
        nine *= 9

print(dp[N])
