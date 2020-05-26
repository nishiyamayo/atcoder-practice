import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())

s = set()
for i in range(K):
    d = int(input())
    s |= set(map(int, input().split()))

print(N - len(s))