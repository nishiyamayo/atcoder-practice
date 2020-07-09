import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

cnt = 0
for i in range(N + 1):
    if i % 2 == 1:
        c = 0
        for j in range(1, i + 1):
            if i % j == 0:
                c += 1

        if c == 8:
            cnt += 1

print(cnt)