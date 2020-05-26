import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

T = int(input())


for _ in range(T):
    N, A, B, C, D = map(int, input().split())
    memo = {}


    def f(n):
        if n == 0:
            return 0
        if n == 1:
            return D
        if n in memo.keys():
            return memo[n]

        ret = 1 << 100
        ret = min(ret, f(n // 2) + (n - n // 2 * 2) * D + A, f(n // 2) + (n - n // 2) * D)
        ret = min(ret, f(n // 3) + (n - n // 3 * 3) * D + B, f(n // 3) + (n - n // 3) * D)
        ret = min(ret, f(n // 5) + (n - n // 5 * 5) * D + C, f(n // 5) + (n - n // 5) * D)
        ret = min(ret, f((n + 1) // 2) + ((n + 1) // 2 * 2 - n) * D + A, f((n + 1) // 2) + (n - (n + 1) // 2) * D)
        ret = min(ret, f((n + 2) // 3) + ((n + 2) // 3 * 3 - n) * D + B, f((n + 2) // 3) + (n - (n + 2) // 3) * D)
        ret = min(ret, f((n + 4) // 5) + ((n + 4) // 5 * 5 - n) * D + C, f((n + 4) // 5) + (n - (n + 4) // 5) * D)
        memo[n] = ret
        return ret

    print(f(N))