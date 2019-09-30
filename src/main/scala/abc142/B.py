N, K = map(int, input().split())

H = list(map(int, input().split()))

cnt = 0
for h in H:
    if h >= K:
        cnt += 1

print(cnt)