N = int(input())

X = list(map(int, input().split()))

M = int(input())

A = list(map(int, input().split()))

B = [False for _ in range(2030)]

for x in X:
    B[x] = True

for a in A:
    if B[X[a - 1] + 1] or X[a - 1] + 1 > 2019:
        pass
    else:
        B[X[a - 1]] = False
        B[X[a - 1] + 1] = True
        X[a - 1] += 1

for x in X:
    print(x)