import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X = int(input())

s = 0
i = 1
while True:
    s += i
    if X <= s:
        print(i)
        break
    i += 1