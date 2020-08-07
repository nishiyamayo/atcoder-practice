import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
import itertools

N = int(input())
K = int(input())
A = [int(input()) for _ in range(N)]
A.sort()

s = set()

for x in itertools.permutations(A):
    s.add("".join(map(str, x[:K])))

print(len(s))