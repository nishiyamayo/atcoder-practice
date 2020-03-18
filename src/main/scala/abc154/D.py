N, K = map(int, input().split())
P = list(map(lambda x: int(x) * (int(x) + 1) / 2 / int(x), input().split()))

S = sum(P[0:K])

ans = S
for s, a in zip(P[0: N - K], P[K: N]):
    S += a - s
    ans = max(ans, S)
print(ans)