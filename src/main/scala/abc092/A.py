import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A,B,C,D=[int(input()) for _ in [0]*4]
print([A,B]*[C,D])


A=[int(input()) for _ in range(4)]
print(min(A[0:2])+min(A[2:4]))