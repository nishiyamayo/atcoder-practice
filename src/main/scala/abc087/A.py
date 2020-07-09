import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X, A, B = [int(input()) for _ in range(3)]

print(X - A - ((X - A) // B) * B)