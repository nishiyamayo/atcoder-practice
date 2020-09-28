import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

a, b, c, d = map(int, input().split())

if a * b <= 0 or c * d <= 0:
    print(max(0, a * c, a * d, b * c, b * d))
else:
    print(max(a * c, a * d, b * c, b * d))
