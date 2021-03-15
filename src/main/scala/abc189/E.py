
N = int(input())
X, Y = [0] * N, [0] * N
for i in range(N):
    X[i], Y[i] = map(int, input().split())

M = int(input())
OP = [input() for _ in range(M)]

Q = int(input())
QS = []
for i in range(Q):
    A, B = map(int, input().split())
    B -= 1
    QS.append((A, B, i))

QS.sort()

T = [[1, 0, 0], [0, 1, 0], [0, 0, 1]]

def mult(A, B):
    C = [[0 for _ in range(3)] for _ in range(3)]
    for i in range(3):
        for j in range(3):
            for k in range(3):
                C[i][k] += A[i][j] * B[j][k]

    return C

cur = 0
ANS = [0] * Q
for q in QS:
    while cur < q[0]:
        if OP[cur] == "1":
            T = mult([[0, 1, 0], [-1, 0, 0], [0, 0, 1]], T)
        elif OP[cur] == "2":
            T = mult([[0, -1, 0], [1, 0, 0], [0, 0, 1]], T)
        else:
            t, p = map(int, OP[cur].split())
            if t == 3:
                T = mult([[1, 0, -p], [0, 1, 0], [0, 0, 1]], T)
                T = mult([[-1, 0, 0], [0, 1, 0], [0, 0, 1]], T)
                T = mult([[1, 0, p], [0, 1, 0], [0, 0, 1]], T)
            else:
                T = mult([[1, 0, 0], [0, 1, -p], [0, 0, 1]], T)
                T = mult([[1, 0, 0], [0, -1, 0], [0, 0, 1]], T)
                T = mult([[1, 0, 0], [0, 1, p], [0, 0, 1]], T)
        cur += 1

    ANS[q[2]] = (T[0][0] * X[q[1]] + T[0][1] * Y[q[1]] + T[0][2], T[1][0] * X[q[1]] + T[1][1] * Y[q[1]] + T[1][2])

for i in range(Q):
    print(ANS[i][0], ANS[i][1])