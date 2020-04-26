import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

ans = 0
for _ in range(3):
    s, e = map(int, input().split())
    ans += s // 10 * e

print(ans)