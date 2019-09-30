N = int(input())
A = list(map(int, input().split()))
B = []

for i in range(0, N - 1):
    if A[i] < A[i + 1]:
        B.append(1)
    elif A[i] > A[i + 1]:
        B.append(-1)
    else:
        B.append(0)

idx = 0

C = []
d = 0

while idx < N - 1:
    if B[idx] == 0 or B[idx] == d:
        pass
    else:

        d = B[idx]
        C.append((A[idx], d, 0 if len(C) == 0 else 1))
    idx += 1

if N > 2 and B[-1] != 0:
    C.append((A[-1], -d, 0))

C.sort(key=lambda x: (x[0], x[1], -x[2]))
# print(C)

ans = 1
cnt = 1
for h, d, a in C:
    if d > 0:
        cnt += a
    else:
        cnt -= 1
    ans = max(ans, cnt)

if len(C) == 0 and A[0] == 0:
    print(0)
else:
    print(ans)
