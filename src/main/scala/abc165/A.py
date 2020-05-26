import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

K = int(input())
A, B = map(int, input().split())

print("OK" if B // K - (A - 1) // K > 0 else "NG")