
R1, C1 = map(int, input().split())
R2, C2 = map(int, input().split())

if R1 == R2 and C1 == C2:
    print(0)
elif abs(R1 - R2) + abs(C1 - C2) <= 3:
    print(1)
elif R1 + C1 == R2 + C2 or R1 - C1 == R2 - C2:
    print(1)
elif (R1 + C1) % 2 == (R2 + C2) % 2:
    print(2)
else:
    ok = False
    for r in range(-3, 4):
        for c in range(-(3 - abs(r)), 3 - abs(r) + 1):
            if (R1 + r) + (C1 + c) == R2 + C2 or (R1 + r) - (C1 + c) == R2 - C2:
                ok = True
    for r in range(-6, 7):
        for c in range(-(6 - abs(r)), 6 - abs(r) + 1):
            if (R1 + r) + (C1 + c) == R2 + C2 or (R1 + r) - (C1 + c) == R2 - C2:
                ok = True
    if ok:
        print(2)
    else:
        print(3)
