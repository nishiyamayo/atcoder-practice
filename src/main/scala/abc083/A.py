import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, C, D = map(int, input().split())

print("Left" if A + B > C + D else "Right" if A + B < C + D else "Balanced")