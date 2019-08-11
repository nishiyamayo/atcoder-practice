
m, n, k = map(int, input().split())
X = map(int, input().split())

c = [0] * (m + 1)
for x in X:
    c[x] += 1

ans = 0

for i in range(m + 1):
    cnt = c[i]
    for j in range(1, k + 1):
        l, r = 0, 0
        if i - j > 0:
            l = 1 if c[i - j] > 0 else 0
        if i + j <= m:
            r = 1 if c[i + j] > 0 else 0
        cnt += max(l, r)
    ans = max(ans, cnt)

print(ans)
