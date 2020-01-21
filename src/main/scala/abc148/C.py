def gcd(a: int, b: int):
    if b == 0:
        return a
    return gcd(b, a % b)

def lcm(a: int, b: int):
    return a * b // gcd(a, b)

a, b = map(int, input().split())
print(lcm(a, b))