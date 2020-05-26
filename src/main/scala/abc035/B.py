import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
T = int(input())

cnt = 0
x, y = 0, 0
for s in S:
    if s == 'U':
        y += 1
    if s == 'R':
        x += 1
    if s == 'D':
        y -= 1
    if s == 'L':
        x -= 1
    if s == '?':
        cnt += 1

if T == 1:
    print(abs(x) + abs(y) + cnt)
else:
    d = abs(x) + abs(y)
    print(d - cnt if d >= cnt else 0 if (cnt - d) % 2 == 0 else 1)
