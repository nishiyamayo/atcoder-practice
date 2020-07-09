import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B = map(int, input().split())

print("Possible" if len(list(filter(lambda x: x % 3 == 0, [A, B, A + B]))) > 0 else "Impossible")