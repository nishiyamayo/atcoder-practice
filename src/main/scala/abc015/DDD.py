import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

W = int(input())
N, K = map(int, input().split())

A, B = [0] * N, [0] * N

for i in range(N):
    A[i], B[i] = map(int, input().split())

dp = [[-1] * (W + 1) for _ in range(K + 1)]

dp[0][0] = 0

ans = 0
for i in range(N):
    for k in range(K, 0, -1):
        for w in range(W, A[i] - 1, -1):
            if dp[k - 1][w - A[i]] >= 0:
                dp[k][w] = max(dp[k][w], dp[k - 1][w - A[i]] + B[i])
                ans = max(ans, dp[k][w])

print(ans)
