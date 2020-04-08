import math
A, B, X = map(float, input().split())

if A * A * B / 2 >= X:
    print(math.degrees(math.atan2(A, X / A / A * 2)))
else:
    print(math.degrees(math.atan2(A, (X - A * A * B) / A / A * 2)))
