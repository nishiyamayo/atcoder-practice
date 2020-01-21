import fractions
import functools

MOD = int(1e9) + 7


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
        return cls.pow(x % MOD, MOD - 2)


N = int(input())
A = list(map(int, input().split()))

MAX_A = 1000010

facts = [0] * MAX_A
p = [False] * MAX_A

def prime():

    for i in range(2, MAX_A):
        p[0] = p[1] = True
        if not p[i]:
            j = 2 * i
            while j < MAX_A:
                p[j] = True
                j += i

prime()

for a in A:
    i = 2
    while i * i <= a:
        if a % i == 0:
            ii = a // i
            c1 = 0
            while a % i == 0:
                c1 += 1
                a //= i
            c2 = 0
            while not p[ii] and a % ii == 0:
                c2 += 1
                a //= ii
            facts[i] = max(facts[i], c1)
            facts[ii] = max(facts[ii], c2)
        i += 1
    if not p[a]:
        facts[a] = max(facts[a], 1)

tar = 1
for idx, c in enumerate(facts):
    if c == 0:
        continue
    tar *= Inv.pow(idx, c)
    tar %= MOD

ans = 0
for a in A:
    ans += tar * Inv.inv(a) % MOD
    ans %= MOD

print(ans)