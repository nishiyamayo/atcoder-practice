import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
S = list(input())

ans = 0
for i in range(1, N - 1):
    l, r = set(S[0: i]), set(S[i:])
    ans = max(ans, len(l & r))

print(ans)