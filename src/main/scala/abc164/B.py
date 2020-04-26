import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, C, D = map(int, input().split())

while A > 0 and C > 0:
    C -= B
    A -= D

print("Yes" if C <= 0 else "No")