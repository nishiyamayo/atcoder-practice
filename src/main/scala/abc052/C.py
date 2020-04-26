import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

MAX = 2000
MOD = int(1e9) + 7
factors = [0] * MAX
primes = []


def p():
    ps = [True] * MAX

    for i in range(2, MAX):
        j = 2 * i
        if not ps[i]:
            continue
        primes.append(i)

        while j < MAX:
            ps[j] = False
            j += i


def fac(x):
    for p in primes:
        while x != 1 and x % p == 0:
            factors[p] += 1
            x //= p


N = int(input())

p()
for i in range(2, N + 1):
    fac(i)

ans = 1
for f in factors:
    ans = ans * (f + 1) % MOD

print(ans)