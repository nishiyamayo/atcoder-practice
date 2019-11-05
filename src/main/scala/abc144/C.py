N = int(input())

ans = N - 1
i = 2
while i * i <= N:
    if N % i == 0:
        ans = min(ans, i + N // i - 2)
    i += 1
print(ans)