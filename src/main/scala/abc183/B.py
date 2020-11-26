Sx, Sy, Gx, Gy = map(int, input().split())

Gy *= -1
ans = -Gy * (Sx - Gx) / (Sy - Gy) + Gx
print(ans)