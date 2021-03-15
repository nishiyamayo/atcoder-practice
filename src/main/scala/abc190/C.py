
N, M = map(int, input().split())
A, B = [0] * M, [0] * M

for i in range(M):
    A[i], B[i] = map(lambda s: int(s) - 1, input().split())

K = int(input())
C, D = [0] * K, [0] * K
for i in range(K):
    C[i], D[i] = map(lambda s: int(s) - 1, input().split())

ans = 0
for i in range(1 << K):
    dish = [0] * N
    for j in range(K):
        if ((i >> j) & 1) == 1:
            dish[C[j]] += 1
        else:
            dish[D[j]] += 1

    cnt = 0
    for j in range(M):
        if dish[A[j]] > 0 and dish[B[j]] > 0:
            cnt += 1
    ans = max(ans, cnt)

print(ans)