
MOD = 998244353
div3 = 332748118

H, W, K = map(int, input().split())
B = [[0 for _ in range(W + 1)] for _ in range(H + 1)]

# 0: R, 1: D, 2: X, 3: _
C = [[3 for _ in range(W + 1)] for _ in range(H + 1)]

for _ in range(K):
    h, w, c = input().split()
    h, w = int(h) - 1, int(w) - 1
    if c == "R":
        C[h][w] = 0
    elif c == "D":
        C[h][w] = 1
    elif c == "X":
        C[h][w] = 2

B[0][0] = 1

pow3 = 1

for h in range(H):
    for w in range(W):
        if C[h][w] == 0:
            B[h][w + 1] += B[h][w]
        elif C[h][w] == 1:
            B[h + 1][w] += B[h][w]
        elif C[h][w] == 2:
            B[h][w + 1] += B[h][w]
            B[h + 1][w] += B[h][w]
        else:
            B[h][w + 1] += B[h][w] * 2 * div3
            B[h + 1][w] += B[h][w] * 2 * div3

        B[h][w + 1] %= MOD
        B[h + 1][w] %= MOD
        pow3 = pow3 * 3 % MOD

for _ in range(K):
    pow3 = pow3 * div3 % MOD

print(B[H - 1][W - 1] * pow3 % MOD)
