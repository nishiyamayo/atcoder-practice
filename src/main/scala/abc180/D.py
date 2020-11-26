
X, Y, A, B = map(int, input().split())

ans = 0
while Y > X and X * A < X + B:
    X *= A
    ans += 1

ans += (Y - X) // B
if (Y - X) % B == 0:
    ans -= 1

print(ans)
