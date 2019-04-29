
from fractions import gcd

n = int(input())
a = [int(v) for v in input().split(" ")]

L = [0]
R = [0]

for i in range(0, n):
    L.append(gcd(L[-1], a[i]))
    R.append(gcd(R[-1], a[-i - 1]))
R.reverse()

ans = 0
for i in range(0, n):
    ans = max(ans, gcd(L[i], R[i + 1]))

print(ans)
