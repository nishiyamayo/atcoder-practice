import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())

if N >= M // 2:
    print(M // 2)
else:
    a = N
    M -= N * 2
    a += M // 4
    print(a)