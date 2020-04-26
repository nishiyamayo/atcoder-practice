import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())
G = [[] for _ in range(N)]
for i in range(M):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    G[a].append(b)
    G[b].append(a)


def search(idx, S):
    if S == (1 << N) - 1:
        return 1

    cnt = 0
    for n in G[idx]:
        if ((S >> n) & 1) == 1:
            continue

        cnt += search(n, S | (1 << n))

    return cnt

print(search(0, 1))