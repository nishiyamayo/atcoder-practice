S = list(input())
cnt = [0] * 3
len = len(S)
sum = 0

for s in S:
    cnt[int(s) % 3] += 1
    sum += int(s) % 3

if sum % 3 == 0:
    print(0)
elif sum % 3 == 1:
    if cnt[1] > 0 and len > 1:
        print(1)
    elif cnt[2] > 1 and len > 2:
        print(2)
    else:
        print(-1)
elif sum % 3 == 2:
    if cnt[2] > 0 and len > 1:
        print(1)
    elif cnt[1] > 1 and len > 2:
        print(2)
    else:
        print(-1)
