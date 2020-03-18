A, B, C = map(int, input().split())
if (A == B and A != C) or (A == C and A != B) or (C == B and A != B):
    print("Yes")
else:
    print("No")