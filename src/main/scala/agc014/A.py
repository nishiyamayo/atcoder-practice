import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, C = map(int, input().split())

s = set()

cnt = 0
while A % 2 == B % 2 == C % 2 == 0:
    if (A, B, C) in s:
        cnt = -1
        break
    s.add((A, B, C))
    A, B, C = B // 2 + C // 2, C // 2 + A // 2, A // 2 + B // 2
    cnt += 1

print(cnt)