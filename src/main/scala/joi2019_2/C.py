N = int(input())

dp = [0 for _ in range(N + 1)]

for i in range(N + 1):
    dp[i] += 1
    a = 0
    x = i
    while x != 0:
        a += x % 10
        x //= 10
    if i + a <= N:
        dp[i + a] += dp[i]

print(dp[N])