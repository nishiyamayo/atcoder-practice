import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = list(input())
B = list(input())
B.reverse()


def ok():
    for a, b in zip(A, B):
        if a != b:
            return False

    return True

print("YES" if ok() else "NO")