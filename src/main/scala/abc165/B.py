import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X = int(input())

A = 100
cnt = 0

while A < X:
    A = int(A * 1.01)
    cnt += 1

print(cnt)