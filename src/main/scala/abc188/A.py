A, B = map(int, input().split())
if A > B:
    A, B = B, A

print("Yes" if A + 3 > B else "No")
