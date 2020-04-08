import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
X = list(map(int, input().split()))

Y = sorted(X)
for i in range(N):
    if X[i] < Y[N // 2]:
        print(Y[N // 2])
    else:
        print(Y[N // 2 - 1])
