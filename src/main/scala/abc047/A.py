import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X = sorted(list(map(int, input().split())))
print("Yes" if X[0] + X[1] == X[2] else "No")