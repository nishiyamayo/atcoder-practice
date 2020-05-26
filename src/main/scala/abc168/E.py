import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

d = {}
zeros = 0

def gcd(a, b):
    while b != 0:
        a, b = b, a % b

    return a

MOD = int(1e9) + 7
p = [1] * (N + 1)
for i in range(N):
    p[i + 1] = p[i] * 2 % MOD
    a, b = map(int, input().split())
    if a == b == 0:
        zeros += 1
        continue
    a, b = a // abs(gcd(a, b)), b // abs(gcd(a, b))

    if a == 0:
        f, s = d.get((a, abs(b)), (0, 0))
        d[(a, abs(b))] = (f + 1, s)

    elif b == 0:
        f, s = d.get((b, abs(a)), (0, 0))
        d[(b, abs(a))] = (f, s + 1)

    elif (a < 0) ^ (b < 0):
        if a < 0:
            a, b = -a, -b
        f, s = d.get((abs(b), a), (0, 0))
        d[(abs(b), a)] = (f, s + 1)
    else:
        f, s = d.get((abs(a), abs(b)), (0, 0))
        d[(abs(a), abs(b))] = (f + 1, s)

ans = 1
for _, (f, s) in d.items():
    cnt = p[f] - 1
    cnt += p[s] - 1
    cnt += 1
    cnt %= MOD
    ans *= cnt
    ans %= MOD

ans -= 1
ans += MOD
ans += zeros
ans %= MOD
print(ans)
