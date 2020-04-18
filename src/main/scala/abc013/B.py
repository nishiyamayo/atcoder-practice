import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = int(input())
B = int(input())

if A > B:
    A, B = B, A

print(min(B - A, 10 - B + A))