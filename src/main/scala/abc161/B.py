import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())
A = list(map(int, input().split()))

S = sum(A)
cnt = 0
for a in A:
    if a * 4 * M >= S:
        cnt += 1
print("Yes" if cnt >= M else "No")
