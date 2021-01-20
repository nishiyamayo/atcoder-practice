def gcd(a, b):
    if not b:
        return a
    return gcd(b, a % b)


def extgcd(a, b):
    if b:
        d, y, x = extgcd(b, a % b)
        y -= (a // b) * x
        return d, x, y
    return a, 1, 0


T = int(input())

for i in range(T):
    N, S, K = map(int, input().split())
    d = gcd(gcd(N, S), K)
    N, S, K = N // d, S // d, K // d
    if gcd(N, K) != 1:
        print(-1)
        continue
    a, x, y = extgcd(K, N)
    x = (x + N) % N
    S = (2 * N - S) % N
    print(x * S % N)

"""
# 問題
- N個の椅子が円状に並んでいる
- K個置きに椅子を移動する
- 初期位置はゴールからS個隣

x * K + S = N * Y

x * K + S ≡ 0 mod N

- d = gcd(N, K, S)とする
- N, K, SをN / d, K / d, S / dに置き換えても問題は成立

# 解説
x * K + S ≡ 0 mod N
<=> x * K ≡ S' mod N (S' = 2 * N - S mod N)

<=> x ≡ K^-1 * S' mod N

Kの逆元: i * K ≡ 1 mod N を満たすi
逆元を求める方法 => 拡張ユークリッドの互助法

# 拡張ユークリッドの互助法ができること
ax + by = gcd(a, b)
となるような解(x, y)を求められる

K * x + N * y = 1 となるような解(x, y)を求めていた
(K * x + N * y) mod N = 1 mod N
∴ K * x ≡ 1 mod N

例）
3 * x + 10 * y = 1
∴(x, y) = (-3, 1)

"""
