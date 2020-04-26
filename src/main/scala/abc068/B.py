import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

cnt = 0
ans = 1
for i in range(1, N + 1):
    x = i
    c = 0
    while x % 2 == 0:
        x //= 2
        c += 1
    if cnt < c:
        cnt = c
        ans = i

print(ans)