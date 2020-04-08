import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

a = max(A)
b = None
used = False
for i in A:
    if i == a and not used:
        used = True
    elif not b or abs(a // 2 - b) > abs(a // 2 - i):
        b = i

print(a, b)