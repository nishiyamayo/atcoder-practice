import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

mem = {}
def gcd(a, b):
    if mem.get((a, b)):
        return mem[(a, b)]
    x, y = a, b
    while b != 0:
        a, b = b, a % b
    mem[(x, y)] = a
    return a

K = int(input())

s = 0
for a in range(1, K + 1):
    for b in range(1, K + 1):
        for c in range(1, K + 1):
            s += gcd(gcd(a, b), c)

print(s)