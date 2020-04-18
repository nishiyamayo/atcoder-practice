import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

a = [0, 0, 1, 0, 1, 2, 3, 0, 1, 0]
N = int(input())
s = sum(map(lambda x: a[int(x)], input().split()))

print(s)