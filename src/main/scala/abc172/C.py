import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M, K = map(int, input().split())
A = [0] + list(map(int, input().split()))
B = [0] + list(map(int, input().split()))

for i in range(1, N + 1):
    A[i] += A[i - 1]

for i in range(1, M + 1):
    B[i] += B[i - 1]

ans = 0

a = N
b = 0

while a >= 0 and b <= M:
    while a >= 0 and A[a] + B[b] > K:
        a -= 1

    while a >= 0 and b <= M and A[a] + B[b] <= K:
        ans = max(ans, a + b)
        b += 1

print(ans)