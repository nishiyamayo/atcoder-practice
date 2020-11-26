
X, Y = map(int, input().split())

if Y == 0:
    print("ERROR")
else:
    print(f"{X * 100 // Y / 100 :.2f}")