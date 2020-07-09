import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy


def gcd(x, y):
    while y != 0:
        x, y = y, x % y

    return x


N, X = map(int, input().split())
x = list(map(int, input().split())) + [X]

x.sort()

y = 0
for i in range(N):
    y = gcd(x[i + 1] - x[i], y)

print(y)
