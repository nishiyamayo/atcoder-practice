W = int(input())
N, K = map(int, input().split())
def l():
    a, b = map(int, input().split())
    return a, b

AB = [l() for _ in range(N)]

dp = []
for _ in range(2):
    dp.append([[-1] * (K + 1) for _ in range(W + 1)])
dp[0][0][0] = 0
ans = 0
x = 1
for i in range(N):
    x = 1 - x
    for w in range(W, -1, -1):
        for k in range(K):
            dp[1 - x][w][k] = max(dp[1 - x][w][k], dp[x][w][k])
            if w - AB[i][0] < 0 or dp[x][w - AB[i][0]][k] < 0:
                continue
            dp[1 - x][w][k + 1] = max(dp[x][w - AB[i][0]][k] + AB[i][1], dp[1 - x][w][k + 1])
            ans = max([ans, dp[1 - x][w][k], dp[1 - x][w][k + 1]])

print(ans)
