import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
S = [list(input()) for _ in range(N)]

for i in range(1, N):
    for j in range(1, 2 * N - 2):
        if S[-i - 1][j] != '#':
            continue

        if S[-i][j - 1] == "X" or S[-i][j] == "X" or S[-i][j + 1] == "X":
            S[-i - 1][j] = 'X'

for s in S:
    print("".join(s))