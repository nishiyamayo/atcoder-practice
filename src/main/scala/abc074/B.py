import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
K = int(input())
A = sum(map(lambda x: 2 * min(int(x), K - int(x)), input().split()))
print(A)