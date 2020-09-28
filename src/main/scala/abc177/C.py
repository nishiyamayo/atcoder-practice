import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

MOD = int(1e9) + 7

N = int(input())
A = list(map(int, input().split()))
S = sum(A) % MOD

ans = 0

for a in A:
    ans += a * (S - a + MOD) % MOD
    ans %= MOD
div2 = (MOD + 1) // 2
print(ans * div2 % MOD)