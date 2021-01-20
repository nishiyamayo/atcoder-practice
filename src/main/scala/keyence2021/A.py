N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

am = 0
ci = 0
for i in range(N):
    am = max(am, A[i])
    ci = max(ci, am * B[i])
    print(ci)

