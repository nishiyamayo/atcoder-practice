import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B = map(int, input().split())
if A == B:
    print("Draw")
elif B == 1 or (A != 1 and A < B):
    print("Bob")
else:
    print("Alice")
