import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())
x = [0] * M
y = [0] * M


# O(N^2 * M) = O(N ^ 4)
def ok(S):
    for i in range(N):
        for j in range(i + 1, N):
            if ((S >> i) & 1) == ((S >> j) & 1) == 1:
                ch = False
                for k in range(M):
                    if i == x[k] and j == y[k]:
                        ch = True
                if not ch:
                    return False

    return True

for i in range(M):
    x[i], y[i] = map(int, input().split())
    x[i] -= 1
    y[i] -= 1

# 2 ^ N
ans = 0
for i in range(1 << N):
    if ok(i):
        ans = max(ans, bin(i).count("1"))

print(ans)
