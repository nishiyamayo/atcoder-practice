import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
S = input()

x = 0
ans = 0
for s in S:
    x += 1 if s == 'I' else -1
    ans = max(ans, x)

print(ans)