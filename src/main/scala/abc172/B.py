import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = list(input())
T = list(input())

cnt = 0
for s, t in zip(S, T):
    cnt += 1 if s != t else 0

print(cnt)
