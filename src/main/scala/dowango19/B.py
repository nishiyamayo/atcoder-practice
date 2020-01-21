N = int(input())
X = list(map(int, input().split()))

MOD = int(1e9) + 7

MUL = [1] * N
for i in range(1, N):
    MUL[i] = MUL[i - 1] * i % MOD

class Combination:
    def __init__(self, N: int, MOD: int):
        fac = [0 for _ in range(N + 1)]
        fac[0] = 1
        for i in range(1, N + 1):
            fac[i] = fac[i - 1] * i % MOD
        self.fac = fac
        self.N = N
        self.MOD = MOD

    def _modpow(self, x: int, n: int) -> int:
        ret = 1
        while n > 0:
            if n % 2 == 1:
                ret = ret * x % self.MOD
            x = x * x % self.MOD
            n >>= 1
        return ret

    def _modinv(self, x: int) -> int:
        return self._modpow(x, self.MOD - 2)

    def combination(self, n: int, k: int) -> int:
        if n < k:
            return 0
        return self.fac[n] * self._modinv(self.fac[k]) % self.MOD * self._modinv(self.fac[n - k]) % self.MOD


def solve():
    if N > 2000:
        print(0)
        return

    comb = Combination(N, MOD)

    if N == 2:
        print(X[1] - X[0])
        return

    ans = 0
    for i in range(0, N - 1):
        for j in range(i + 1, N):

            # i -> j (N - (j - i)) C 3
            i2j = j - i - 1
            outof_i2j = N - i2j - 2
            if j != N - 1:
                outof_i2j -= 1

            print(i, j, i2j, outof_i2j, MUL[i2j], MUL[outof_i2j])
            x = i2j + 2 if j != N - 1 else i2j + 1
            y = outof_i2j
            print(x, y, comb.combination(max(x, y) + 1, min(x, y)))

            ans += (X[j] - X[i]) * MUL[i2j] * MUL[outof_i2j] * comb.combination(max(x, y) + 1, min(x, y))
            ans %= MOD
    print(ans)

solve()