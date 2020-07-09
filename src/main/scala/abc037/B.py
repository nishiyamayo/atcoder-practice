import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, Q = map(int, input().split())

ar = [0] * N

for i in range(Q):
    L, R, T = map(int, input().split())
    for i in range(L - 1, R):
        ar[i] = T


for a in ar:
    print(a)
