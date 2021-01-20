import sys

sys.setrecursionlimit(100000000)

N, M = map(int, input().split())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

mem = dict()


def solve(i, j):
    if i == N or j == M:
        return N - i + M - j

    if (i, j) in mem:
        return mem[(i, j)]

    ret = solve(i + 1, j + 1) + 1

    for k in range(i, M):
        s = solve(i + 1, k + 1)
        x = k - j
        y = 0 if A[i] == B[k] else 1
        ret = min(ret, s + x + y)

    for k in range(j, N):
        s = solve(k + 1, j + 1)
        x = k - i
        y = 0 if A[k] == B[j] else 1
        ret = min(ret, s + x + y)

    mem[(i, j)] = ret
    return ret


print(solve(0, 0))
