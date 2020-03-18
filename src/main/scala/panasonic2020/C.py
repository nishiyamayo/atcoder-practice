A, B, C = map(int, input().split())


print("Yes" if (C - A - B) * (C - A - B) - 4 * A * B > 0 and C > A + B else "No")