import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
X, Y = map(int, input().split())

y = (Y - 2 * X) // 2
x = (4 * X - Y) // 2

if y < 0 or x < 0 or x + y != X or 2 * x + 4 * y != Y:
    print("No")
else:
    print("Yes")