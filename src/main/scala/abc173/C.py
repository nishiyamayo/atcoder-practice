import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H, W, K = map(int, input().split())

B = [[] for _ in range(H)]

for h in range(H):
    B[h] = list(input())

ans = 0
for i in range(1 << H):
    for j in range(1 << W):
        cnt = 0
        for h in range(H):
            for w in range(W):
                if ((i >> h) & 1) == 1 or ((j >> w) & 1) == 1:
                    continue
                if B[h][w] == '#':
                    cnt += 1
        if cnt == K:
            ans += 1

print(ans)