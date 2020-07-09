import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S, T = input(), input()

L = len(S)

ok = False

for i in range(L):
    if T == S[i:L] + S[0:i]:
        ok = True

print("Yes" if ok else "No")
