import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K, X, Y = [int(input()) for _ in range(4)]

ans = min(N, K) * X

print(min(N, K) * X + (N - min(N, K)) * Y)