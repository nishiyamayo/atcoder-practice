N = int(input())
X = list(map(int, input().split()))

ans = 1 << 30
for p in range(1, 101):
    sum = 0
    for x in X:
        sum += (x - p) ** 2
    ans = min(ans, sum)

print(ans)