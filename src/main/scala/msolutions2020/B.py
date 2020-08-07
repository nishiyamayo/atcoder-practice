import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, C = map(int, input().split())
K = int(input())

while A >= B:
    B *= 2
    K -= 1
while B >= C:
    C *= 2
    K -= 1

print("Yes" if K >= 0 else "No")