import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, K = map(int, input().split())
S = sorted(list(set([i for i in range(A, min(A + K, B))] + [i for i in range(max(A, B - K + 1), B + 1)])))
for s in S:
    print(s)
