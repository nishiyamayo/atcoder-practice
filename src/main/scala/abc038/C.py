import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

c = 0
cur = 0
ans = 0
for i in range(N):
    if cur < A[i]:
        c += 1
        cur = A[i]
        ans += c
    else:
        c = 1
        cur = A[i]
        ans += c

print(ans)