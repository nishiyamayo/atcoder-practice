import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X, Y = input().split()

if X == Y:
    print('=')
elif X < Y:
    print("<")
else:
    print(">")