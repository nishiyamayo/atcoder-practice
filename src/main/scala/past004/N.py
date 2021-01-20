
dp = [[[0] * (1 << 6) for _ in range(1 << 6)] for _ in range(20)]

dp[0][0][0] = 1
MOD = int(1e9) + 7

for n in range(1, 19):
    L = input()

    for i in range(1 << 6):
        for j in range(1 << 6):
            for k in range(1 << 6):
                ok = True
                for h in range(6):
                    ok &= L[h] == "?" or (L[h] == "1" and ((i >> h) & 1) == 1) or (L[h] == "0" and ((i >> h) & 1) == 0)
                if not ok:
                    continue
                for h in range(6):
                    cnt = (k >> h) & 1
                    cnt += (j >> h) & 1
                    cnt += (j >> (h + 1)) & 1
                    if h - 1 >= 0:
                        cnt += (j >> (h - 1)) & 1
                    cnt += (i >> h) & 1
                    ok &= (cnt >= 3 and ((j >> h) & 1) == 1) or (cnt <= 2 and ((j >> h) & 1) == 0)
                if not ok:
                    continue
                dp[n][j][i] += dp[n - 1][k][j]

for j in range(1 << 6):
    for k in range(1 << 6):
        ok = True
        for h in range(6):
            cnt = (k >> h) & 1
            cnt += (j >> h) & 1
            cnt += (j >> (h + 1)) & 1
            if h - 1 >= 0:
                cnt += (j >> (h - 1)) & 1
            cnt += (0 >> h) & 1
            ok &= (cnt >= 3 and ((j >> h) & 1) == 1) or (cnt <= 2 and ((j >> h) & 1) == 0)
        if not ok:
            continue
        dp[19][j][0] += dp[18][k][j]


ans = 0
for i in range(1 << 6):
    for j in range(1 << 6):
        ans += dp[19][i][j]

print(ans)
