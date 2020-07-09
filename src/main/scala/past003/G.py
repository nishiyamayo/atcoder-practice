import queue
import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

OFFSET = 400

N, X, Y = map(int, input().split())
X += OFFSET
Y += OFFSET

board = [[1 << 60] * 800 for _ in range(800)]
board[OFFSET][OFFSET] = 0

for i in range(800):
    board[0][i] = board[i][0] = board[800 - 1][i] = board[i][800 - 1] = -1

for i in range(N):
    x, y = map(int, input().split())
    board[OFFSET + y][OFFSET + x] = -1

dx = [1, 0, -1, 1, -1, 0]
dy = [1, 1, 1, 0, 0, -1]


def solve():
    s = (OFFSET, OFFSET, 0)
    q = queue.Queue()
    q.put(s)

    while not q.empty():
        cx, cy, cnt = q.get()
        if X == cx and Y == cy:
            return cnt

        for nx, ny in zip(dx, dy):
            if board[cy + ny][cx + nx] >= 0 and board[cy + ny][cx + nx] > cnt + 1:
                q.put((cx + nx, cy + ny, cnt + 1))
                board[cy + ny][cx + nx] = cnt + 1

    return -1

print(solve())