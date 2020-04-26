import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

W = int(input())
N, K = map(int, input().split())
A = [0] * N
B = [0] * N

for i in range(N):
    a, b = map(int, input().split())
    A[i] = a
    B[i] = b

dp = [[-1] * (K + 1) for _ in range(W + 1)]
dp[0][0] = 0

ans = 0
for i in range(N):
    tmp = [[0] * (K + 1) for _ in range(W + 1)]
    for k in range(K + 1):
        for w in range(W, -1, -1):
            tmp[w][k] = max(tmp[w][k], dp[w][k])
            if dp[w][k] >= 0 and w + A[i] <= W and k + 1 <= K:
                tmp[w + A[i]][k + 1] = max(tmp[w + A[i]][k + 1], dp[w][k] + B[i])
                ans = max(ans, tmp[w + A[i]][k + 1])
    dp = tmp

print(ans)