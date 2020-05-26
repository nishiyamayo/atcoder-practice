import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, C = sorted(list(map(int, input().split())))

print("YES" if A == B == 5 and C == 7 else "NO")