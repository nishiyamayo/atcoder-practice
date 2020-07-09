import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))
A.sort()

L = 1000010
ps = [False] * L

cs = [0] * L
for i in range(N):
    cs[A[i]] += 1

cnt = 0
for i in range(N):
    if cs[A[i]] > 1:
        if not ps[A[i]]:
            j = A[i]
            while j < L:
                ps[j] = True
                j += A[i]
        continue
    if not ps[A[i]]:
        ps[A[i]] = True
        cnt += 1
        j = A[i] * 2
        while j < L:
            ps[j] = True
            j += A[i]

print(cnt)