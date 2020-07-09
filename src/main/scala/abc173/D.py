import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

A = list(map(int, input().split()))
A.sort(reverse=True)

ans = 0
cur = 0
for i in range(N - 1):
    ans += A[cur]
    if i < 1:
        cur += 1
    elif i % 2 == 0:
        cur += 1

print(ans)