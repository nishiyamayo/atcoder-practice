import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = 1000 - int(input())

coins = [500, 100, 50, 10, 5, 1]

cnt = 0
for coin in coins:
    cnt += A // coin
    A -= (A // coin) * coin

print(cnt)