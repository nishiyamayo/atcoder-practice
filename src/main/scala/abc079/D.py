import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H, W = map(int, input().split())
wf = [list(map(int, input().split())) for _ in range(10)]
board = [list(map(int, input().split())) for _ in range(H)]

for _ in range(3):
    for i in range(10):
        for j in range(10):
            for k in range(10):
                wf[i][j] = min(wf[i][j], wf[i][k] + wf[k][j])

converted = sum([(wf[board[h][w]][1] if board[h][w] >= 0 else 0) for w in range(W) for h in range(H)])

print(converted)
