import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = [(idx, v) for idx, v in enumerate(list(map(int, input().split())))]

A.sort(key=lambda t:t[1], reverse=True)
for a in A:
    print(a[0] + 1)