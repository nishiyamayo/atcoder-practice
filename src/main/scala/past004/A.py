A, B, C = map(int, input().split())

print("A" if B > A > C or C > A > B else "B" if A > B > C or C > B > A else "C")