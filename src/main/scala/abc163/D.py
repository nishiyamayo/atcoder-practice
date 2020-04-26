import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())

MOD = int(1e9) + 7
sum = 0
for i in range(K, N + 2):
    sum += (N - i + 1) * i + 1
    sum %= MOD
    # print(i, (N - i + 1) * i + 1)

print(sum)