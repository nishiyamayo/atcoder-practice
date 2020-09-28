import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
D, X = map(int, input().split())

A = [int(input()) for _ in range(N)]

for i in range(N):
    for j in range(1, D + 1, A[i]):
        X += 1

print(X)