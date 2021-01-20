N, M, T = map(int, input().split())
V = N
cur = 0
ok = True
for i in range(M):
    A, B = map(int, input().split())
    V = max(0, V - (A - cur))
    # print(i, V)
    if V == 0:
        ok = False
    V = min(N, V + B - A)
    cur = B

# print(M, V)
V = max(0, V - (T - cur))
if V == 0:
    ok = False

# print(V)
print("Yes" if ok else "No")
