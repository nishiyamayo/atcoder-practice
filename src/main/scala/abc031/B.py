import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

L, H = map(int, input().split())
N = int(input())

for i in range(N):
    A = int(input())
    if L <= A <= H:
        print(0)
    elif A < L:
        print(L - A)
    else:
        print(-1)