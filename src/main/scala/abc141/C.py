N, K, Q = map(int, input().split())

A = [int(input()) for _ in range(Q)]

C = [0 for _ in range(N)]

for a in A:
    C[a - 1] += 1

for c in C:
    if K - (Q - c) > 0:
        print("Yes")
    else:
        print("No")
