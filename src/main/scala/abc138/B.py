n = int(input())

A = map(int, input().split())

ans = 0

for a in A:
    ans += 1.0 / a

print("%.10f" % (1.0 / ans))
