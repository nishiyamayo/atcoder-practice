a, b = map(int, input().split())

cnt = 1
s = a
if b == 1:
    print(0)
else:
    while True:
        if b <= s:
            print(cnt)
            break
        s -= 1
        s += a
        cnt += 1
