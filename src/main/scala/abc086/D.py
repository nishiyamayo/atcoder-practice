import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())
X, Y, C = [[0] * N for _ in range(3)]

mem = [[0] * (4 * K + 1) for _ in range(4 * K + 1)]

for i in range(N):
    S = input().split()
    X[i], Y[i], C[i] = int(S[0]), int(S[1]), S[2]
    x, y = X[i] % (2 * K) + 1, (Y[i] + (K if C[i] == "W" else 0)) % (2 * K) + 1
    mem[x][y] += 1
    mem[x + K][y] -= 1
    mem[x][y + K] -= 1
    mem[x + K][y + K] += 1

for h in range(1, 4 * K + 1):
    for w in range(1, 4 * K + 1):
        mem[h][w] += mem[h - 1][w] + mem[h][w - 1] - mem[h - 1][w - 1]

ans = 0
for h in range(K + 1):
    for w in range(K + 1):
        s = mem[h][w] + mem[h + 2 * K][w] + mem[h][w + 2 * K] + mem[h + K][w + K] + mem[h + 2 * K][w + 2 * K]
        ans = max(ans, s)

for h in range(K + 1):
    for w in range(K, 2 * K + 1):
        s = mem[h][w] + mem[h + 2 * K][w] + mem[h + K][w - K] + mem[h + K][w + K]
        ans = max(ans, s)


print(ans)