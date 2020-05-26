import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
F = [int("".join(input().split()), base=2) for _ in range(N)]
P = [list(map(int, input().split())) for _ in range(N)]

ans = - (1 << 30)
for i in range(1 << 10):
    profit = 0
    ok = False
    for j in range(N):
        cnt = bin(i & F[j]).count("1")
        if cnt > 0:
            ok = True
        profit += P[j][cnt]

    if ok:
        ans = max(ans, profit)

print(ans)
