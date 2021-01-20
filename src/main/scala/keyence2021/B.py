N, K = map(int, input().split())
A = list(map(int, input().split()))
d = [0 for _ in range(N)]

for a in A:
    d[a] += 1

m = K
ans = 0
for i in range(N):
    if not d[i]:
        ans += i * m
        break
    ans += i * (m - min(m, d[i]))
    m = min(m, d[i])

print(ans)
