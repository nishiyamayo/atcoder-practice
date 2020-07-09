import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())
X = [0] * N
Y = [0] * N

for i in range(N):
    X[i], Y[i] = map(int, input().split())

for i in range(N):
    for j in range(N):
        pass
