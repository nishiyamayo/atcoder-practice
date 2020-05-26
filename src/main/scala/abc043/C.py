import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

ans = 1 << 28

for i in range(-100, 101):
    ans = min(ans, sum(map(lambda x: (i - x) ** 2, A)))

print(ans)