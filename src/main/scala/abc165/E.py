import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())

used = [False] * N

if N % 2 == 1:
    for i in range(M):
        print(N // 2 - i, N // 2 + i + 1)
else:
    for i in range(M):
        # 左に作る
        if i % 2 == 0:
            c = N // 2 // 2
            d = i // 2
            print(c - d, c + d + 1)
        # 右に作る
        else:
            c = N // 2 + (N // 2 + 1) // 2
            d = (i + 1) // 2
            print(c - d, c + d)

