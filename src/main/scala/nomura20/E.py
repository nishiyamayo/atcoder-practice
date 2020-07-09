import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

T = list(map(int, list(input())))
n = len(T)
ones = sum(T)

cnt = 0

for i in range(1, ones + 1):
    cnt += (i + 1) // 2

a, b = 0, 0
for i in range(n):
    if T[i] == 1:
        if i % 2 == 0:
            a += 1
        else:
            b += 1

l = 0
r = l - 1
ac = 0
bc = 0
for it in range(n - ones):
    if a < b:
        while T[l] == 1:
            if l % 2 == 0:
                ac += 1
            else:
                bc += 1
            l += 1
        cnt += a - ac
        a, b = b, a
    else:
        x = 0
        while T[r] == 1:
            x += 1
            r -= 1
        cnt += a
        if x % 2 != 0:
            a -= 1
            b += 1


print(cnt)