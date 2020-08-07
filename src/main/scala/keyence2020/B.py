import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
R = []

for i in range(N):
    x, l = map(int, input().split())
    R.append((x + l, x - l))

R.sort()

l = -(1 << 40)

cnt = 0
for r in R:
    if l <= r[1]:
        cnt += 1
        l = r[0]

print(cnt)
