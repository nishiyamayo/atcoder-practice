import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H, W = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(H)]

ans = []


def root(s, g):
    sx, sy = s
    gx, gy = g

    sx += 1
    sy += 1
    gx += 1
    gy += 1

    while sx != gx or sy != gy:
        if sy % 2 == 0 and sx == 1:
            ans.append((sy, sx, sy + 1, sx))
            sy += 1
        elif sy % 2 == 1 and sx == W:
            ans.append((sy, sx, sy + 1, sx))
            sy += 1
        else:
            if sy % 2 == 1:
                ans.append((sy, sx, sy, sx + 1))
                sx += 1
            else:
                ans.append((sy, sx, sy, sx - 1))
                sx -= 1


s = None
for h in range(H):
    if h % 2 == 0:
        for w in range(W):
            if A[h][w] % 2 == 1:
                if s:
                    root(s, (w, h))
                    A[h][w] -= 1
                    A[s[1]][s[0]] += 1
                    s = None
                    pass
                else:
                    s = (w, h)
    else:
        for w in range(W - 1, -1, -1):
            if A[h][w] % 2 == 1:
                if s:
                    root(s, (w, h))
                    A[h][w] -= 1
                    A[s[1]][s[0]] += 1
                    s = None
                    pass
                else:
                    s = (w, h)


l = len(ans)
print(l)
for a in ans:
    print(*a)