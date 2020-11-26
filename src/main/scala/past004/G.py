import sys
sys.setrecursionlimit(100000)

N, M = map(int, input().split())
B = [list(input()) for _ in range(N)]
V = sum([x.count(".") for x in B]) + 1

dx, dy = [-1, 0, 1, 0], [0, -1, 0, 1]


def dfs(x, y, B):
    if x < 0 or y < 0 or x >= M or y >= N or B[y][x] == "#":
        return 0
    B[y][x] = "#"
    cnt = 1
    for nx, ny in zip(dx, dy):
        cnt += dfs(x + nx, y + ny, B)
    return cnt

ans = 0

for Y in range(N):
    for X in range(M):
        C = [B[i].copy() for i in range(N)]
        C[Y][X] = "."
        if dfs(X, Y, C) == V:
            ans += 1

print(ans)
