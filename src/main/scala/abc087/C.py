import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A1 = list(map(int, input().split()))
A2 = list(map(int, input().split()))
A2.reverse()

for i in range(1, N):
    A1[i] += A1[i - 1]
    A2[i] += A2[i - 1]

A2.reverse()

ans = 0
for i in range(N):
    ans = max(ans, A1[i] + A2[i])

print(ans)

