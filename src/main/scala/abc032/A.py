import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, n = [int(input()) for _ in range(3)]

while n % A != 0 or n % B != 0:
    n += 1

print(n)
