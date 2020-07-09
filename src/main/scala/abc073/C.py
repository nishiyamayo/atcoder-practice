import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

s = set()
for i in range(N):
    A = int(input())
    if A in s:
        s.remove(A)
    else:
        s.add(A)

print(len(s))