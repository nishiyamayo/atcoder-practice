N, W = map(int, input().split())
MAX = 3 * 100000
s = [0] * MAX

for i in range(N):
    S, T, P = map(int, input().split())
    s[S] += P
    s[T] -= P

ok = True
for i in range(1, MAX):
    s[i] += s[i - 1]
    ok &= s[i] <= W

ok &= s[0] <= W

print("Yes" if ok else "No")