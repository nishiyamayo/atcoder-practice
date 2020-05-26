import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = input()
B = input()
C = input()

T = [A, B, C]
t = [0, 0, 0]
l = [len(A), len(B), len(C)]



def solve():
    x = 0
    while True:
        if l[x] == t[x]:
            print("A" if x == 0 else "B" if x == 1 else "C")
            return

        nx = T[x][t[x]]
        t[x] += 1
        x = 0 if nx == "a" else 1 if nx == "b" else 2

solve()