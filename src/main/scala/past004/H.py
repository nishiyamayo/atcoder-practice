
N, M, K = map(int, input().split())
S = [input() for _ in range(N)]

ans = 1
for n in range(2, min(N, M) + 1):
    for Y in range(N):
        for X in range(M):
            if Y + n > N or X + n > M:
                continue
            cnt = [0] * 10
            for y in range(Y, Y + n):
                for x in range(X, X + n):
                    cnt[int(S[y][x])] += 1
            if max(cnt) + K >= n * n:
                ans = n

print(ans)
