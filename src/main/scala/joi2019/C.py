n, m = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = A + B
C.sort()
for c in C:
    print(c)
