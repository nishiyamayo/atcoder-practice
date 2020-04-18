import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

if N % 10 == 7 or N // 10 % 10 == 7 or N // 100 % 10 == 7:
    print("Yes")
else:
    print("No")