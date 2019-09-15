import sys

sys.setrecursionlimit(10000)

a, b = map(int, input().split())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

# mem[x][y][teban] = (teban, teki): Aの山がx, Bの山がyのとき、tebanの最大スコアと敵の最大スコアのタプル
mem = [[[None for _ in range(2)] for _ in range(b + 2)] for _ in range(a + 2)]

ac = 0
bc = 0

SUNUKE = 0
SUMEKE = 1


def calc(ac, bc, turn):
    if ac == a and bc == b:
        return (0, 0)

    if mem[ac][bc][turn]:
        return mem[ac][bc][turn]

    left, right = ((0, 0), (0, 0))
    if ac < a:
        left = calc(ac + 1, bc, SUMEKE if turn == SUNUKE else SUMEKE)
        left = (left[0] + A[ac], left[1])
    if bc < b:
        right = calc(ac, bc + 1, SUMEKE if turn == SUNUKE else SUMEKE)
        right = (right[0] + B[bc], right[1])

    mem[ac][bc][turn] = (left[1], left[0]) if left[0] > right[0] else (right[1], right[0])
    return mem[ac][bc][turn]

ans = calc(0, 0, SUNUKE)
print(ans[1])
