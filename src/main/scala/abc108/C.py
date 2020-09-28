import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
N, K = map(int, input().split())
print((N // K) ** 3 if K % 2 == 1 else (((N // K) ** 3) + ((N - K // 2) // K + 1) ** 3))