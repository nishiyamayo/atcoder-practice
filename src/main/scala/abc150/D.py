import itertools
import functools

N, M = map(int, input().split())
A = list(map(int, input().split()))

A = list(map(lambda x: x // 2, A))

def gcd(a, b):
    while b != 0:
        a, b = b, a % b

    return a

def lcm(a, b):
    return a // gcd(a, b) * b

def ok(A):
    def f(x, y):
        return x % 2 == y % 2
    return functools.reduce(f, A, A[0])

pow2 = functools.reduce(gcd, A, A[0])
while pow2 % 2 == 0:
    A = list(map(lambda x: x // 2, A))
    pow2 //= 2
    M //= 2

x = functools.reduce(lcm, A, 1)

if x % 2  == 0:
    print(0)
else:
    print(M // x - M // (2 * x))