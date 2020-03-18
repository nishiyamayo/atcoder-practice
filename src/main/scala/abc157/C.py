N, M = map(int, input().split())

S = [0] * M
C = [0] * M

for i in range(M):
    s, c = map(int, input().split())
    S[i] = s - 1
    C[i] = c

def ok(x):
    X = str(x)
    for i in range(M):
        # print(S[i], C[i])
        # print(len(X) >= S[i], int(X[S[i]]) != C[i])
        if len(X) <= S[i]:
            return False
        if int(X[S[i]]) != C[i]:
            return False

    return len(X) == N

def pr():
    for i in range(1000):
        if ok(i):
            print(i)
            return
    print(-1)

pr()