def mult_1e9(x: str):
    idx = x.find(".")
    if idx < 0:
        return int(x + "000000000")

    l = len(x) - idx - 1
    return int(x.replace(".", "") + "0" * (9 - l))


def factors25(i):
    cnt2 = 0
    while i % 2 == 0:
        cnt2 += 1
        i //= 2

    cnt5 = 0
    while i % 5 == 0:
        cnt5 += 1
        i //= 5

    return cnt2, cnt5

N = int(input())
A = list(map(mult_1e9, [input() for _ in range(N)]))
B = list(map(factors25, A))
print(A)
print(B)