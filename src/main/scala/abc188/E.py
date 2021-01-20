
N, M = map(int, input().split())
A = list(map(int, input().split()))
g = [[] for _ in range(N)]

for i in range(M):
    x, y = map(int, input().split())
    g[y - 1].append(x - 1)

ans = int(-1e15)

dp = [1e15 for _ in range(N)]
for i in range(N):
    for fr in g[i]:
        dp[i] = min(dp[i], dp[fr])
    ans = max(ans, A[i] - dp[i])
    dp[i] = min(dp[i], A[i])

print(ans)
