import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

s = 0
for i in range(N + 1):
    if i % 3 != 0 and i % 5 != 0:
        s += i

print(s)