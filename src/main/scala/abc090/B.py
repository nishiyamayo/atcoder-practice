import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B = map(int, input().split())

def ok(n):
    s = str(i)
    l = len(s)
    for j in range(l):
        if s[j] != s[-(j + 1)]:
            return False
    return True

ans = 0
for i in range(A, B + 1):
    if ok(i):
        ans += 1

print(ans)
