import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

dp = [1 << 28] * (N + 10)
dp[0] = 0
for i in range(N):
    if i >= 2:
        dp[i] = min(dp[i], dp[i - 2] + abs(A[i] - A[i - 2]))
    if i >= 1:
        dp[i] = min(dp[i], dp[i - 1] + abs(A[i] - A[i - 1]))

print(dp[N - 1])