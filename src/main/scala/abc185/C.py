
L = int(input())

ans = 1
for i in range(L - 1, L - 1 - 11, -1):
    ans *= i

for i in range(11, 1, -1):
    ans //= i

print(ans)