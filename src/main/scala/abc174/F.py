import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, Q = map(int, input().split())
C = list(map(int, input().split()))



for i in range(Q):
    l, r = map(int, input().split())
