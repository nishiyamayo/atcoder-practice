import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

r = int(input())

if r < 1200:
    print("ABC")
elif r < 2800:
    print("ARC")
else:
    print("AGC")