import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, X = map(int, input().split())
A = list(map(int, input().split()))

D = 0
cnt = 0
while D <= X and cnt <= N:
    if cnt != N:
        D += A[cnt]
    cnt += 1

print(cnt)