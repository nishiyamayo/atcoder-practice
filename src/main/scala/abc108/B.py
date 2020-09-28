import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

x1, y1, x2, y2 = map(int, input().split())

print(x2 - (y2 - y1), y2 + (x2 - x1), x1 - (y2 - y1), y1 + (x2 - x1))
