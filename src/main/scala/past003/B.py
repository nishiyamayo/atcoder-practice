import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M, Q = map(int, input().split())
solve_num = [0] * M
solved = [[False] * M for _ in range(N)]

for i in range(Q):
    t = list(map(int, input().split()))

    if t[0] == 1:
        t[1] -= 1
        score = 0
        for i in range(M):
            score += (N - solve_num[i]) * (1 if solved[t[1]][i] else 0)
        print(score)
    else:
        t[1] -= 1
        t[2] -= 1
        solved[t[1]][t[2]] = True
        solve_num[t[2]] += 1