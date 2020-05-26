import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = input()

print("Yes" if A[0] == A[1] == A[2] or A[1] == A[2] == A[3] else "No")