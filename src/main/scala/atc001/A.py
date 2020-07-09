import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

sys.setrecursionlimit(10000000)

H, W = map(int, input().split())
board = [[False] * (W + 2) for _ in range(H + 2)]
sx, sy = -1, -1
gx, gy = -1, -1

for y in range(1, H + 1):
    walls = ["#"] + list(input()) + ["#"]
    for x in range(1, W + 1):
        board[y][x] = True if walls[x] in [".", "g", "s"] else False
        if walls[x] == "s":
            sx, sy = x, y
        if walls[x] == "g":
            gx, gy = x, y

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def rec(x, y):
    if x == gx and y == gy:
        return True
    board[y][x] = False

    ret = False
    for nx, ny in zip(dx, dy):
        if board[y + ny][x + nx]:
            ret |= rec(x + nx, y + ny)
            if ret:
                break

    return ret


print("Yes" if rec(sx, sy) else "No")
