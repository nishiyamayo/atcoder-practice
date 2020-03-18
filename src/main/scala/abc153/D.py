H = int(input())

cnt = 0
while H > 0:
    H //= 2
    cnt *= 2
    cnt += 1

print(cnt)