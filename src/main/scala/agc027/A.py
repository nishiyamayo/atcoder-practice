import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, x = map(int, input().split())
A = list(map(int, input().split()))
A.sort()
cnt = 0
for a in A:
    if x >= a:
        cnt += 1
        x -= a
    else:
        x = 0
if x > 0:
    cnt -= 1
print(cnt)