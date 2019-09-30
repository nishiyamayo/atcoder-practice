N = int(input())
A = list(map(int, input().split()))

B = [(A[idx], idx) for idx in range(N)]
C = sorted(B)
D = [c[1] + 1 for c in C]

print(*D)
