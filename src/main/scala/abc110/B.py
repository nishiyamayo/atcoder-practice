import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M, X, Y = map(int, input().split())
XS = list(map(int, input().split())) + [X]
YS = list(map(int, input().split())) + [Y]

print("No War" if max(XS) < min(YS) else "War")