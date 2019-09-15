import math
txa, tya, txb, tyb, T, V = map(int, input().split())
n = int(input())
XY = [tuple(map(int, input().split())) for _ in range(n)]

flag = False
for (x, y) in XY:
    if math.sqrt((txa - x) * (txa - x) + (tya - y) * (tya - y)) + math.sqrt((txb - x) * (txb - x) + (tyb - y) * (tyb - y)) <= T * V:
        flag = True

print("YES" if flag else "NO")
