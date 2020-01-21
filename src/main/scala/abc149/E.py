import bisect
N, M = map(int, input().split())
A = list(map(int, input().split()))
S = [0] * (N + 1)

A = sorted(A)
A = [0] + A


for idx, v in enumerate(A):
    if idx == 0:
        continue
    S[idx] += A[idx] + S[idx - 1]

def ok(x: int):
    cnt = 0

    for a in A:
        if a == 0:
            continue
        idx = bisect.bisect_right(A, x - a, 0, N + 1)
        cnt += N - (idx - 1)

    return cnt < M

def calc(M: int, x: int):
    ret = 0
    for a in A:
        idx = bisect.bisect_right(A, x - a, 0, N + 1)
        M -= N - idx + 1
        ret += (N - idx + 1) * a + S[N] - S[idx - 1]

    print(M, ret)

    ret += M * x
    return ret


def solve():
    l, r = 0, int(1e12)

    while r - l > 1:
        c = (l + r) // 2
        if ok(c):
            r = c
        else:
            l = c

    return calc(M, r)

print(solve())