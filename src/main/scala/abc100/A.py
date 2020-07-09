import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
A, B = map(int, input().split())
print("Yay!" if A <= 8 and B <= 8 else ":(")