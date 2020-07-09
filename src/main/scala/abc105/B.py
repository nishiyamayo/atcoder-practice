import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())


def ok():
    x = 0
    while x * 4 <= N:
        if (N - x * 4) % 7 == 0:
            return True
        x += 1
    return False

print("Yes" if ok() else "No")
