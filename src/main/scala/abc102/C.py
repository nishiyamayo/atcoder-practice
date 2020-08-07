import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

for i in range(N):
    A[i] -= i + 1

A.sort()
central = A[N // 2]

ans = 0
for i in range(N):
    ans += abs(central - A[i])
print(ans)