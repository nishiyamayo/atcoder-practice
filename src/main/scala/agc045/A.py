import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

T = int(input())


def solve():
    N = int(input())
    A = list(map(int, input().split()))
    S = input()

    for i in range(N - 1, -1, -1):
        if S[i] == '1':
            for j in range(i + 1, N):
                pass


for _ in range(T):
    solve()