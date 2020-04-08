import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X = int(input())

c = int(X // 500)
a = c * 1000
X -= c * 500
b = int(X // 5) * 5
print(a + b)