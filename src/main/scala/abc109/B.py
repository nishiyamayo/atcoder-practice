import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
W = [input() for _ in range(N)]

s = W[0][-1]

ok = True
used = set()
used.add(W[0])
for w in W[1:]:
    if s != w[0] or w in used:
        ok = False

    s = w[-1]
    used.add(w)

print("Yes" if ok else "No")
