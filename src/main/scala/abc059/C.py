import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

p = A[0] if A[0] > 0 else 1
pc = 0 if A[0] > 0 else 1 - A[0]
m = A[0] if A[0] < 0 else -1
mc = 0 if A[0] < 0 else 1 + abs(A[0])

for i in range(1, N):
    p += A[i]
    m += A[i]
    if i % 2 == 0:
        if p <= 0:
            pc += 1 - p
            p = 1
        if m >= 0:
            mc += 1 + m
            m = -1
    else:
        if p >= 0:
            pc += 1 + p
            p = -1
        if m <= 0:
            mc += 1 - m
            m = 1

print(min(pc, mc))
