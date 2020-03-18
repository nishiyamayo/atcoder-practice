H, W = map(int, input().split())
print((H * W + 1) // 2 if H != 1 and W != 1 else 1)