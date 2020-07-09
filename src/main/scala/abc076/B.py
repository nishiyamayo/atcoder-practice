import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
K = int(input())

def solve(n):
    if n == N:
        return 1

    v = solve(n + 1)
    return min(v * 2, v + K)

print(solve(0))