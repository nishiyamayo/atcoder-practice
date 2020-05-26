import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
ans = [''] * len(S)
cur = 0
for s in S:
    if s == 'B':
        cur -= 1
        ans[cur] = ''
        cur = max(0, cur)
    else:
        ans[cur] = s
        cur += 1

print("".join(ans))