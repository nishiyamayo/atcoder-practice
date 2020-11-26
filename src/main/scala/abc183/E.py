H, W = map(int, input().split())
MOD = int(1e9) + 7

S = ["#" * (W + 1)]
for i in range(H):
    S.append("#" + input())

dp = [[0] * (W + 1) for _ in range(H + 1)]
s = [[[0, 0, 0] for _ in range(W + 1)] for _ in range(H + 1)]
dp[1][1] = 1
for h in range(1, H + 1):
    for w in range(1, W + 1):
        if h == w == 1:
            continue
        if S[h][w] == "#":
            continue

        dp[h][w] = dp[h - 1][w] + dp[h][w - 1] + dp[h - 1][w - 1]
        dp[h][w] += s[h - 1][w - 1][0] + s[h - 1][w][1] + s[h][w - 1][2]
        dp[h][w] %= MOD

        s[h][w][0] = s[h - 1][w - 1][0] + (dp[h - 1][w - 1] if S[h - 1][w - 1] == '.' else 0)
        s[h][w][1] = s[h - 1][w][1] + (dp[h - 1][w] if S[h - 1][w] == '.' else 0)
        s[h][w][2] = s[h][w - 1][2] + (dp[h][w - 1] if S[h][w - 1] == '.' else 0)
        s[h][w][0] %= MOD
        s[h][w][1] %= MOD
        s[h][w][2] %= MOD

print(dp[h][w])