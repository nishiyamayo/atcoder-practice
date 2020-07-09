import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = list(map(int, input().split()))

for i in range(5):
    if A[i] != i + 1:
        print(i + 1)