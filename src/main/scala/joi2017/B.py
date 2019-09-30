n = int(input())
A = list(map(int, input().split()))

ans = 0
cnt = 0
for a in A:
    if a == 1:
        cnt += 1
    else:
        cnt = 0
    ans = max(ans, cnt)

print(ans + 1)