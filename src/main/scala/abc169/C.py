import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B = input().split()

A = int(A)
B = int(B.replace(".", ""))

print(A * B // 100)