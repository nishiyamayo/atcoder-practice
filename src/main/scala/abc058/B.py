import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

O = list(input())
E = list(input())

print("".join([o + (e if e else "") for (o, e) in zip_longest(O, E)]))