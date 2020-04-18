import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

W, H, x, y = map(int, input().split())

if W == x * 2 and H == y * 2:
    print(W * H / 2, 1)
else:
    print(W * H / 2, 0)