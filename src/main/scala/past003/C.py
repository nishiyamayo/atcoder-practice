import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, R, N = map(int, input().split())

s = A
mult = R
N -= 1
while N > 0 and s <= int(1e9):
    if N & 1 == 1:
        s *= mult
    mult *= mult
    N >>= 1

print("large" if s > int(1e9) else s)