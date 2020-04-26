import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
print("Second" if (len(S) % 2 == 0) ^ (S[0] == S[-1]) else "First")