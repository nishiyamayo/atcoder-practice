import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, C = map(int, input().split())
D = max(A, B, C)
S = sum([A, B, C])
print((D * 3 - S) // 2 if D % 2 == S % 2 else ((D + 1) * 3 - S) // 2)