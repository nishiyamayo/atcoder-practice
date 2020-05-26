import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

W, H = map(int, input().split())

print("16:9" if W % 16 == 0 and H % 9 == 0 else "4:3")