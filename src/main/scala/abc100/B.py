import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

D, N = map(int, input().split())

if N == 100:
    print(100 ** D * (N + 1))
else:
    print(100 ** D * N)