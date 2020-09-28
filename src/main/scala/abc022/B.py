import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
B = [-1] * 100001
for _ in range(N):
    B[int(input())] += 1

print(sum(B) + B.count(-1))