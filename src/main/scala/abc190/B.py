N, S, D = map(int, input().split())

ok = False
for i in range(N):
    X, Y = map(int, input().split())
    ok |= X < S and Y > D

print("Yes" if ok else "No")