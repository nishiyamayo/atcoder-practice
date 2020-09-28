import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

L = 0
ans = 0
for a in A:
    if L > a:
        ans += L - a
    else:
        L = a

print(ans)