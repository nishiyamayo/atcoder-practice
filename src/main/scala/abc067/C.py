import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

s = sum(A)

x = 0
ans = 1 << 60
for a in A[:-1]:
    x += a
    ans = min(ans, abs(s - 2 * x))

print(ans)