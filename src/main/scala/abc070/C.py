import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = [int(input()) for _ in range(N)]

def gcd(a, b):
    while b != 0:
        a, b = b, a % b

    return a

def lcm(a, b):
    return a // gcd(a, b) * b


ans = 1
for a in A:
    ans = lcm(ans, a)

print(ans)