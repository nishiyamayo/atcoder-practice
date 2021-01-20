
MOD = 998244353

H, W, K = map(int, input().split())
B = [[[0] * 2 for _ in range(W + 1)] for _ in range(H + 1)]

# 0: R, 1: D, 2: X, 3: _
C = [[3 for _ in range(W + 1)] for _ in range(H + 1)]

for _ in range(K):
    h, w, c = input().split()
    h, w = int(h), int(w)
    if c == "R":
        C[h][w] = 0
    elif c == "D":
        C[h][w] = 1
    elif c == "X":
        C[h][w] = 2

if C[1][1] == 0:
    B[1][1][0] = 1
elif C[1][1] == 1:
    B[1][1][1] = 1
elif C[1][1] == 2:
    B[1][1][0] = 1
    B[1][1][1] = 1
else:
    B[1][1][0] = 2
    B[1][1][1] = 2

for h in range(1, H + 1):
    for w in range(1, W + 1):
        if h == w == 1:
            continue

        if C[h][w] == 0:
            B[h][w][0] += B[h][w - 1][0] + B[h - 1][w][1]
        elif C[h][w] == 1:
            B[h][w][1] += B[h][w - 1][0] + B[h - 1][w][1]
        elif C[h][w] == 2:
            B[h][w][0] += B[h][w - 1][0] + B[h - 1][w][1]
            B[h][w][1] += B[h][w - 1][0] + B[h - 1][w][1]
        else:
            B[h][w][0] += 2 * (B[h][w - 1][0] + B[h - 1][w][1])
            B[h][w][1] += 2 * (B[h][w - 1][0] + B[h - 1][w][1])

        B[h][w][0] %= MOD
        B[h][w][1] %= MOD

print((B[H][W][0] + B[H][W][1]) % MOD)