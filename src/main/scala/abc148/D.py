n = int(input())
A = list(map(int, input().split()))

cnt = 0
cur = 1
for x in A:
    if x == cur:
        cur += 1
    else:
        cnt += 1

print(cnt if cnt != len(A) else -1)