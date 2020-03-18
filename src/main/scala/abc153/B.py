H, N = map(int, input().split())
A = list(map(int, input().split()))
v = "Yes" if sum(A) >= H else "No"
print(v)