import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())

c = N // K

print(min(N - c * K, (c + 1) * K - N))