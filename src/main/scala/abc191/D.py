OFFSET = 6 * 10 ** 9

X, Y, R = map(lambda s: round(float(s) * 10000), input().split())
X += OFFSET
Y += OFFSET

def count_point(x):
    if abs(x - X) > R:
        return 0

    l, r = 0, Y
    while l + 1 < r:
        c = (l + r) // 2
        if (X - x) ** 2 + (Y - c) ** 2 > R ** 2:
            l = c
        else:
            r = c

    left_side = r - 1
    l, r = Y, 3 * OFFSET
    while l + 1 < r:
        c = (l + r) // 2
        if (X - x) ** 2 + (Y - c) ** 2 <= R ** 2:
            l = c
        else:
            r = c

    right_side = l

    ans = right_side // 10 ** 4
    ans -= left_side // 10 ** 4
    # print(X, Y, left_side, right_side, ans)

    return ans


cnt = 0
for x in range(0, 2 * OFFSET, 10 ** 4):
    cnt += count_point(x)

print(cnt)
