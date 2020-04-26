import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(filter(lambda x: x != 0, map(int, input().split())))

print((sum(A) + len(A) - 1) // len(A))