N = int(input())


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


def lcm(a, b):
    return a // gcd(a, b) * b


m = 1
for i in range(1, N + 1):
    m = lcm(m, i)

print(m + 1)
