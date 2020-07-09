import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X, N = map(int, input().split())
A = []
if N != 0:
    A = set(map(int, input().split()))

ans = 0
d = 1 << 28
for i in range(200):
    if i not in A and abs(X - i) < d:
        ans = i
        d = abs(X - i)

print(ans)