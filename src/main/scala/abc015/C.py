import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())

T = [list(map(int, input().split())) for _ in range(N)]

def f(i, xor):
    if i == N:
        return xor == 0

    flag = False
    for j in T[i]:
        flag |= f(i + 1, xor ^ j)

    return flag

print("Found" if f(0, 0) else "Nothing")