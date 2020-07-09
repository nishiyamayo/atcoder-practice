import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H1, M1, H2, M2, K = map(int, input().split())

MS1 = H1 * 60 + M1
MS2 = H2 * 60 + M2

print(MS2 - MS1 - K)