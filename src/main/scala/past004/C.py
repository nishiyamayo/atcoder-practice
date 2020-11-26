
N, M = map(int, input().split())
B = [input() for _ in range(N)]

dx = [-1, 0, 1, 1, 1, 0, -1, -1, 0]
dy = [-1, -1, -1, 0, 1, 1, 1, 0, 0]
for X in range(N):
    l = ""
    for Y in range(M):
        cnt = 0
        for (nx, ny) in zip(dx, dy):
            x, y = X + nx, Y + ny
            if x < 0 or x >= N or y < 0 or y >= M:
                continue
            cnt += 1 if B[x][y] == "#" else 0
        l += str(cnt)
    print(l)
