N, X = map(int, input().split())
S = list(input())

for s in S:
    if s == "x":
        X = max(0, X - 1)
    else:
        X += 1

print(X)