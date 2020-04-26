import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
a, b = input().split()
c = int(a + b)

def ok(x):
    i = 2
    while i * i < x:
        i += 1

    return i * i == x

print("Yes" if ok(c) else "No")