N = int(input())
P = list(map(int, input().split()))

cnt = 0
x = N + 1
for p in P:
    if x > p:
        cnt += 1
    x = min(x, p)

print(cnt)