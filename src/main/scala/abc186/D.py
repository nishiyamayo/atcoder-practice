N = int(input())

A = list(map(int, input().split()))
A.sort()
B = [0 for _ in range(N + 1)]
for i in range(0, N):
    B[i + 1] = B[i] + A[i]

ans = 0
for i in range(N):
    ans += A[i] * i - (B[i] - B[0])
#     ans += B[N] - B[i + 1] - A[i] * (N - i - 1)
#     print(A[i] * i - (B[i] - B[0]), B[N] - B[i] - A[i] * (N - i - 1))

print(ans)