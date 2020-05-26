import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

sx, sy, tx, ty = map(int, input().split())

ans = []

for i in range(tx - sx):
    ans.append("R")

for i in range(ty - sy):
    ans.append("U")

for i in range(tx - sx):
    ans.append("L")

for i in range(ty - sy):
    ans.append("D")

ans.append("D")

for i in range(tx - sx + 1):
    ans.append("R")

for i in range(ty - sy + 1):
    ans.append("U")

ans.append("L")

ans.append("U")

for i in range(tx - sx + 1):
    ans.append("L")

for i in range(ty - sy + 1):
    ans.append("D")

ans.append("R")

print("".join(ans))