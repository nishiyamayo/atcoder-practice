import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

n = int(input())

i = 1
ans = 1 << 28
while i * i <= n:
    ans = min(ans, n - i * (n // i) + abs(i - n // i))
    i += 1

print(ans)