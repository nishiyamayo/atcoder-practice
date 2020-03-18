N = input()
K = int(input())
N = "0" + N
K = int(K)

L = len(N)

dp = [[[0] * (K + 1) for _ in range(2)] for _ in range(L)]
dp[0][0][0] = 1

for i in range(1, L):
    d = int(N[i])
    # 境界
    for k in range(0, K + 1):
        dp[i][1][k] += dp[i - 1][1][k]
        if d != 0:
            dp[i][1][k] += dp[i - 1][0][k]

    for k in range(1, K + 1):
        dp[i][1][k] += dp[i - 1][1][k - 1] * 9
        if d != 0:
            dp[i][1][k] += dp[i - 1][0][k - 1] * (d - 1)
            dp[i][0][k] += dp[i - 1][0][k - 1]
        else:
            dp[i][0][k] += dp[i - 1][0][k]

print(dp[-1][0][K] + dp[-1][1][K])
