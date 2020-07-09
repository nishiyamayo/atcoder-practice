import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X, Y = map(int, input().split())

cnt = 1
while X <= Y:
    X *= 2
    cnt += 1

print(cnt - 1)