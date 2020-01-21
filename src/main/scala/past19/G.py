N = int(input())
A = [[0] * N for _ in range(N)]

for i in range(N - 1):
    a = list(map(int, input().split()))
    for j in range(N - i - 1):
        A[i][j + i + 1] = a[j]


def rec(c, ar):
    if c == N:
        return calc(ar)

    ret = -(1 << 60)
    for i in range(3):
        ar[c] = i
        ret = max(ret, rec(c + 1, ar))
    return ret

def calc(ar):
    cost = 0
    for i in range(N - 1):
        for j in range(i + 1, N):
            if ar[i] == ar[j]:
                cost += A[i][j]

    return cost

print(rec(0, [0] * N))