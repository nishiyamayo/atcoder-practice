import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

cnt = [0] * (6 * 10000 + 1)

for x in range(1, 100):
    for y in range(1, 100):
        for z in range(1, 100):
            cnt[x ** 2 + y ** 2 + z ** 2 + x * y + y * z + z * x] += 1

for i in range(1, N + 1):
    print(cnt[i])
