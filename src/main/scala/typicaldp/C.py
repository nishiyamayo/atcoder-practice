
K = int(input())
N = 2 ** K

R = [int(input()) for _ in range(N)]


dp = [[0 for _ in range(N)] for _ in range(K + 1)]

dp[0] = [1.0 for _ in range(N)]

for i in range(1, K + 1):
    stage = N // (2 ** i)
    for s in range(stage):
        for vs1 in range(2 ** (i - 1)):
            for vs2 in range(2 ** (i - 1)):
                l = (2 ** i) * s + vs1
                r = (2 ** i) * s + (2 ** (i - 1)) + vs2
                print(s, vs1, vs2, (2 ** i) * s + vs1, (2 ** i) * s + (2 ** (i - 1)) + vs2)
                rq = 1.0 / (1 + 10 ** ((R[l] - R[r]) / 400))
                rp = 1.0 / (1 + 10 ** ((R[r] - R[l]) / 400))
                dp[i][l] = rp * (dp[i - 1][l] * dp[i - 1][r])
                dp[i][r] = rq * (dp[i - 1][l] * dp[i - 1][r])

#print(dp)
for i in range(N):
    print("%.10f" % dp[K][i])
