
H, W, N, M = map(int, input().split())
B1 = [[False for _ in range(W + 2)] for _ in range(H + 2)]
B2 = [[False for _ in range(W + 2)] for _ in range(H + 2)]
B3 = [[False for _ in range(W + 2)] for _ in range(H + 2)]
B4 = [[False for _ in range(W + 2)] for _ in range(H + 2)]
C = [[False for _ in range(W + 2)] for _ in range(H + 2)]

for i in range(H):
    C[i][0] = C[i][W + 1] = True

for i in range(W):
    C[0][i] = C[H + 1][i] = True

for i in range(N):
    b, a = map(int, input().split())
    B1[b][a] = B2[b][a] = B3[b][a] = B4[b][a] = True

for i in range(M):
    d, c = map(int, input().split())
    C[d][c] = True

for x in range(1, W + 1):
    for y in range(1, H + 1):
        if C[y][x]:
            continue
        B1[y][x] |= B1[y][x - 1]
        B2[y][x] |= B2[y - 1][x]

for x in range(W, 0, -1):
    for y in range(H, 0, -1):
        if C[y][x]:
            continue
        B3[y][x] |= B3[y][x + 1]
        B4[y][x] |= B4[y + 1][x]

cnt = 0
for x in range(1, W + 1):
    for y in range(1, H + 1):
        if B1[y][x] | B2[y][x] | B3[y][x] | B4[y][x]:
            cnt += 1

print(cnt)
