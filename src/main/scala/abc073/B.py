import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
ans = 0
for i in range(N):
    a, b = map(int, input().split())
    ans += b - a + 1

print(ans)