N = int(input())
A = list(map(int, input().split()))

ans = 0
tar = -1
for i in range(2, 1000):
    cnt = 0
    for a in A:
        if a % i == 0:
            cnt += 1
    if ans < cnt:
        ans = cnt
        tar = i

print(tar)
