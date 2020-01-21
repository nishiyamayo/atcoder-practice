a, b = input().split()

S = [a * int(b), b * int(a)]
S.sort()

print(S[0])