import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()

x = [0] * 3
for s in S:
    if s == 'a':
        x[0] += 1
    elif s == 'b':
        x[1] += 1
    else:
        x[2] += 1

if x[0] > x[1] and x[0] > x[2]:
    print("a")
if x[1] > x[0] and x[1] > x[2]:
    print("b")
if x[2] > x[1] and x[2] > x[0]:
    print("c")