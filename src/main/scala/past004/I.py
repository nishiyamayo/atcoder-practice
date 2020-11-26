N = int(input())
A = list(map(int, input().split()))
S = sum(A)
A = A * 2

l, r = 0, 0
sum = 0
ans = S
while l < N:
    while sum < S // 2:
        ans = min(ans, abs((S - sum) - sum))
        sum += A[r]
        r += 1

    while sum >= S // 2:
        ans = min(ans, abs((S - sum) - sum))
        sum -= A[l]
        l += 1

print(ans)
