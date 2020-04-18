import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
C = [0] * N
S = [0] * N
F = [0] * N

for i in range(N - 1):
    C[i], S[i], F[i] = map(int, input().split())

ans = [0] * N

for i in range(N):
    cur = S[i] + C[i]
    for j in range(i + 1, N - 1):
        if cur < S[j]:
            cur = S[j] + C[j]
        else:
            d = (cur - S[j])
            cnt = (d + F[j] - 1) // F[j]
            cur = S[j] + cnt * F[j] + C[j]
    ans[i] = cur

for a in ans:
    print(a)