N = int(input())
Z, W = [], []

for i in range(N):
    X, Y = map(int, input().split())
    Z.append(X + Y)
    W.append(X - Y)

max_z, min_z = max(Z), min(Z)
max_w, min_w = max(W), min(W)

print(max(max_z - min_z, max_w - min_w))
