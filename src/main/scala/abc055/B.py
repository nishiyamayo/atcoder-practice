import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

MOD = int(1e9) + 7
a = 1
for i in range(1, N + 1):
    a = a * i % MOD

print(a)