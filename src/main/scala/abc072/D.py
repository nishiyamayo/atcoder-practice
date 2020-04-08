import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(lambda x: int(x) - 1, input().split()))

cnt = 0
for i in range(N - 1):
    if A[i] == i:
        cnt += 1
        A[i], A[i + 1] = A[i + 1], A[i]

if A[N - 1] == N - 1:
    cnt += 1

print(cnt)

# 1 2 3 4 5
# 3 2 1 4 5