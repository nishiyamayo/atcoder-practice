N, M = map(int, input().split())
A = list(map(int, input().split()))
A.sort()

K = N
if A and A[0] != 1:
    K = min(K, A[0] - 1)

if A and A[-1] != N:
    K = min(K, N - A[-1])


for i in range(M - 1):
    if A[i + 1] - A[i] - 1 != 0:
        K = min(K, A[i + 1] - A[i] - 1)

if K == 0:
    print(0)
else:
    cur = 0
    ans = 0
    for a in A:
        cnt = (a - cur - 1 + K - 1) // K
        ans += cnt
        cur = a
        # print(K, ans)

    cnt = (N - cur + K - 1) // K
    ans += cnt

    print(ans)
