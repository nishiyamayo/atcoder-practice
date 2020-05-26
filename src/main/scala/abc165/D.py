import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, N = map(int, input().split())

if B - 1 <= N:
    print(A * (B - 1) // B)
else:
    print(A * N // B - A * (N // B))