N = int(input())

if N % 2 == 1:
    print(0)
else:
    cnt = 0
    pow = 10
    while pow <= N:
        cnt += N // pow
        pow *= 5
    print(cnt)