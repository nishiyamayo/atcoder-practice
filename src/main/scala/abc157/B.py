a11, a12, a13 = map(int, input().split())
a21, a22, a23 = map(int, input().split())
a31, a32, a33 = map(int, input().split())

N = int(input())
B = [int(input()) for _ in range(N)]

def ok(a, b, c):
    return B.__contains__(a) and B.__contains__(b) and B.__contains__(c)

print("Yes" if ok(a11, a12, a13) or ok(a21, a22, a23) or ok(a31, a32, a33) or ok(a11, a21, a31) or ok(a12, a22, a23) or ok(a13, a23, a33) or ok(a11, a22, a33) or ok(a13, a22, a31) else "No")