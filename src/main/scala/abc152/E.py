import fractions
import functools

MOD = int(1e9) + 7


def lcm(a, b):
    c, d = a, b
    while d != 0:
        c, d = d, c % d
    return a // c * b


class Inv:

    @classmethod
    def pow(cls, x: int, n: int) -> int:
        ret = 1
        while n > 0:
            if n % 2 == 1:
                ret = ret * x % MOD
            x = x * x % MOD
            n >>= 1
        return ret

    @classmethod
    def inv(cls, x: int) -> int:
        return cls.pow(x, MOD - 2)


N = int(input())
A = list(map(int, input().split()))

v = functools.reduce(lcm, A)
v %= MOD
ans = 0
for a in A:
    ans = (ans + v * Inv.inv(a)) % MOD
print(ans)
