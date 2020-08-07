import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = [s.split("*") for s in input().split("+")]

cnt = 0
for s in S:
    if "0" not in s:
        cnt += 1

print(cnt)