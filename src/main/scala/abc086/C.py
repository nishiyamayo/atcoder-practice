import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

ct, cx, cy = (0, 0, 0)

ok = True
for i in range(N):
    t, x, y = map(int, input().split())

    d = abs(cx - x) + abs(cy - y)
    dt = t - ct

    if d > dt or (d - dt) % 2 == 1:
        ok = False
    ct, cx, cy = t, x, y

print("Yes" if ok else "No")
