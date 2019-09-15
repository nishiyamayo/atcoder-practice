N, K = map(int, input().split())

dp = [[0 for _ in range(2)] for _ in range(N + 1)]
dp[0][0] = dp[1][1] = 1

MOD = int(1e9) + 7

for i in range(2, N + 1):
    dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD
    dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % MOD

    if i - K >= 0:
        dp[i][1] = (dp[i][1] - dp[i - K][0] + MOD) % MOD

print(dp[N][1])
