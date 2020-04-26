import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, x = map(int, input().split())
A = list(map(int, input().split()))

s = sum(A)
for i in range(1, N):
    if A[i] + A[i - 1] > x:
        d = sum(A[i - 1:i + 1]) - x
        for j in range(2):
            if d <= 0:
                break
            A[i - j], d = A[i - j] - min(A[i - j], d), d - min(A[i - j], d)

print(s - sum(A))