n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))

ans = 0
past = -10
for i in range(n):
    ans += B[A[i] - 1]
    if past == A[i] - 1 - 1:
        ans += C[A[i] - 1 - 1]
    past = A[i] - 1

print(ans)