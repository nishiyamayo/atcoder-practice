import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, S = [int(input()), int(input())]


def solve1():
    i = 2
    while i * i <= N:
        if ok(i, N, S):
            return i

        i += 1

    return 1 << 60


def solve2():
    i = 1
    ret = 1 << 60
    while i * i <= N:
        b = (N - S) // i + 1
        if ok(b, N, S):
            ret = min(ret, b)
        i += 1

    return ret


def ok(b, N, S):
    if b <= 1:
        return False

    s, n = 0, N
    while n > 0:
        s += n % b
        n //= b

    return s == S



def solve():
    if S == N:
        return N + 1
    ret = min(solve1(), solve2())
    return ret if ret != 1 << 60 else -1


print(solve())
