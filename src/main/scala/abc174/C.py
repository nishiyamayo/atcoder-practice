import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())


def solve():
    divs = set()
    r = 0
    cnt = 1
    while (r * 10 + 7) % N not in divs:
        r = (r * 10 + 7) % N
        divs.add(r)
        if r == 0:
            return cnt
        cnt += 1

    return -1


print(solve())