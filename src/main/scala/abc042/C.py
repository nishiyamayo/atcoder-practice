import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())
D = list(map(int, input().split()))


def ok(X):
    for d in D:
        if str(d) in str(X):
            return False
    return True

while not ok(N):
    N += 1

print(N)