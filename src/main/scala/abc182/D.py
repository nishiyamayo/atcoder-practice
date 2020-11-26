
N = int(input())
A = list(map(int, input().split()))
B = [0] * N
B[0] = A[0]
for i in range(1, N):
    A[i] += A[i - 1]
    B[i] = max(B[i - 1], A[i])

cur = 0
ans = 0
for i in range(N):
    ans = max(ans, cur + B[i])
    cur += A[i]

print(ans)
