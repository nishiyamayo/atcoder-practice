import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

A = {}
for _ in range(N):
    a = input()
    A[a] = A.get(a, 0) + 1

M = int(input())
B = {}
for _ in range(M):
    b = input()
    B[b] = B.get(b, 0) + 1

ans = 0
for k, v in A.items():
    ans = max(ans, v - B.get(k, 0))

print(ans)