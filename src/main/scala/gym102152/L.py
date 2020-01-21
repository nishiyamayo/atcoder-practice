import sys
input = sys.stdin.readline

N, M, H, W = map(int, input().split())

board = [[0] * (M + 2)]
board += [[0] + list(map(int, input().split())) + [0] for _ in range(N)]


def ok(x):
    cnts = [[0] * (M + 2) for _ in range(N + 2)]

    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if board[i][j] > x:
                continue
            lux = max(1, i - H + 1)
            luy = max(1, j - W + 1)
            cnts[lux][luy] += 1
            cnts[i + 1][j + 1] += 1
            cnts[lux][j + 1] -= 1
            cnts[i + 1][luy] -= 1

    mcnt = 0
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            cnts[i][j] += cnts[i - 1][j] + cnts[i][j - 1] - cnts[i - 1][j - 1]
            mcnt = max(mcnt, cnts[i][j])

    return mcnt > W * H // 2


def search():
    l, r = 0, M * N

    while l + 1 < r:
        c = (l + r) // 2
        if ok(c):
            r = c
        else:
            l = c

    return r


print(search())
