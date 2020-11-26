N = int(input())
S = input()

ans = 2 * N
L, R = N, N
for l in range(N):
    for r in range(N):
        c = [S[i] == "#" for i in range(N)]
        f, cnt = False, 0
        for i in range(N):
            if c[i]:
                f, cnt = True, l
            c[i] |= f
            cnt -= 1
            f = cnt >= 0

        f, cnt = False, 0
        for i in range(N - 1, -1, -1):
            if c[i]:
                f, cnt = True, r
            c[i] |= f
            cnt -= 1
            f = cnt >= 0

        if c.count(True) == N:
            if ans > l + r:
                ans = l + r
                L, R = l, r

print(R, L)