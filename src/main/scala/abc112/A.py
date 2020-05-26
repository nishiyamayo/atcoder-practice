import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = input()

if A == "1":
    print("Hello World")
else:
    X = int(input())
    Y = int(input())
    print(X + Y)