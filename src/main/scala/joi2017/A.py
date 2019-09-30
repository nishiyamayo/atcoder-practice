n, a, b, c, d = map(int, input().split())

x = ((n + a - 1) // a) * b
y = ((n + c - 1) // c) * d
print(min(x, y))
