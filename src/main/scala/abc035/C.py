import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, Q = map(int, input().split())

imos = [0] * (N + 2)

for i in range(Q):
    l, r = map(int, input().split())
    imos[l] += 1
    imos[r + 1] -= 1

for i in range(1, N + 2):
    imos[i] += imos[i - 1]

print("".join(list(map(lambda x: "0" if x % 2 == 0 else "1", imos[1 : N + 1]))))