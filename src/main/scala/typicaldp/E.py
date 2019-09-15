D = int(input())
N = "0" + input()

dp = [[[0 for _ in range(2)] for _ in range(D)] for _ in range(len(N) + 1)]
dp[0][0][1] = 1

MOD = int(1e9) + 7

for i in range(1, len(N)):
    dig = int(N[i])
    for d in range(D):
        dp[i][(d + dig) % D][1] = (dp[i][(d + dig) % D][1] + dp[i - 1][d][1]) % MOD
        for x in range(dig):
            dp[i][(d + x) % D][0] = (dp[i][(d + x) % D][0] + dp[i - 1][d][1]) % MOD
        for x in range(10):
            dp[i][(d + x) % D][0] = (dp[i][(d + x) % D][0] + dp[i - 1][d][0]) % MOD

print(dp[len(N) - 1][0][0] + dp[len(N) - 1][0][1] - 1)
