n = int(input())
A = map(int, input().split())

A = sorted(A)


for i in range(n - 1):
    A[i + 1] = (A[i] + A[i + 1]) / 2

print("%.9f" % A[n - 1])
