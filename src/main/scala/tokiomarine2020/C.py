import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())
A = list(map(int, input().split()))

K = min(100, K)

for i in range(K):
    B = [0] * (N + 1)
    for j in range(N):
        l, r = max(0, j - A[j]), min(N, j + A[j] + 1)
        B[l] += 1
        B[r] -= 1

    for j in range(1, N):
        B[j] += B[j - 1]
    A = B[:-1]

print(*A)