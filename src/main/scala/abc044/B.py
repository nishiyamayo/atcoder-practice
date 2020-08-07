import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

W = input()

ok = [True] * 26

for w in W:
    idx = ord(w) - ord("a")
    ok[idx] = not ok[idx]

print("Yes" if all(ok) else "No")