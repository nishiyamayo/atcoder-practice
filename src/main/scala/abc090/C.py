import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())

N, M = min(N, M), max(N, M)
if N == M == 1:
    print(1)
elif N == 1:
    print(M - 2)
elif N == 2:
    print(0)
else:
    print(N * M - 2 * (N - 1) - 2 * (M - 1))