import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

x, a, b = map(int, input().split())
print("A" if abs(x - a) < abs(x - b) else "B")