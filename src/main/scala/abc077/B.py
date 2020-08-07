import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())


def ans():
    for i in range(100000):
        if i * i > N:
            return (i - 1) * (i -1)


print(ans())
