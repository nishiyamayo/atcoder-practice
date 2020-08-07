import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
T = list(map(int, input().split()))
S = sum(T)

M = int(input())

for i in range(M):
    p, x = map(int, input().split())

    print(S - T[p - 1] + x)
