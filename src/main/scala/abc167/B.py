import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, C, K = map(int, input().split())

ans = 0
ans += min(K, A)
K -= A
if K > 0:
    K -= B
if K > 0:
    ans -= min(K, C)
    K -= C

print(ans)