import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
hs = [()] * N

for i in range(N):
    hs[i] = tuple(map(int, input().split()))

def ok(x):
    hs.sort(key=lambda t: (t[0] - x) / t[1], reverse=True)

    for i in range(N):
        if hs[i][0] + i * hs[i][1] > x:
            return False

    return True

l, r = 0, 1 << 60

while l + 1 < r:
    c = (l + r) // 2
    if ok(c):
        r = c
    else:
        l = c

print(r)