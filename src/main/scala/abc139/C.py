N = int(input())
H = list(map(int, input().split()))

cur = 0
cnt = 0
ans = 0
for i in range(N):
    if cur >= H[i]:
        cnt += 1
    else:
        cnt = 0
    cur = H[i]
    ans = max(ans, cnt)
print(ans)