n = int(input())

m = 10007

a = 0
b = 0
c = 1

for _ in range(n - 3):
    a, b, c = b, c, (a + b + c) % m

if n > 2:
    print(c)
else:
    print(0)