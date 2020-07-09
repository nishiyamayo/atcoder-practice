import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

A = [input() for _ in range(N)]

def solve():

    ret = ""
    for i in range(N // 2):
        ok = False
        for t in A[i]:
            if t in A[-(i + 1)]:
                ok = True
                ret += t
                break

        if not ok:
            return "-1"

    rev = list(ret)
    rev.reverse()
    rev = "".join(rev)

    return ret + ("" if N % 2 == 0 else A[N // 2][0]) + rev

print(solve())