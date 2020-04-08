import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M, X = map(int, input().split())
A = list(map(int, input().split()))

cnt = 0
for a in A:
    if a > X:
        break
    cnt += 1

print(min(cnt, M - cnt))