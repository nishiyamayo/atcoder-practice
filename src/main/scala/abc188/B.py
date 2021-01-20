
N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = sum(map(lambda v: v[0] * v[1], zip(A, B)))
print("Yes" if C == 0 else "No")
