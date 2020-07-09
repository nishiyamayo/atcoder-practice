import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
from queue import Queue

H, W = map(int, input().split())

A = [list(input()) for _ in range(H)]


def solve():
    q = Queue()
    q.put((0, 0, 1))
    A[0][0] = "#"

    dx = [0, -1, 0, 1]
    dy = [-1, 0, 1, 0]
    while not q.empty():
        cx, cy, cnt = q.get()

        if cx == W - 1 and cy == H -1:
            return cnt

        for xx, yy in zip(dx, dy):
            nx, ny = cx + xx, cy + yy
            if nx < 0 or nx >= W or ny < 0 or ny >= H:
                continue
            if A[ny][nx] == "#":
                continue
            A[ny][nx] = "#"
            q.put((nx, ny, cnt + 1))
        pass

    return -1

sh = 0
for h in range(H):
    for w in range(W):
        if A[h][w] == "#":
            sh += 1

d = solve()
print(H * W - d - sh if d >= 0 else -1)