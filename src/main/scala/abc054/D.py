import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, Ma, Mb = map(int, input().split())
A = [0] * N
B = [0] * N
C = [0] * N

for i in range(N):
    A[i], B[i], C[i] = map(int, input().split())

INF = 1 << 50
LEN = 500
dp = [[INF] * (LEN + 1) for _ in range(LEN + 1)]
dp[0][0] = 0

for i in range(N):
    for j in range(LEN, A[i] - 1, -1):
        for k in range(LEN, B[i] - 1, -1):
            dp[j][k] = min(dp[j][k], dp[j - A[i]][k - B[i]] + C[i])

cnt = 1
ans = INF
while cnt * Ma < LEN and cnt * Mb < LEN:
    ans = min(ans, dp[cnt * Ma][cnt * Mb])
    cnt += 1

print(ans if ans != INF else -1)