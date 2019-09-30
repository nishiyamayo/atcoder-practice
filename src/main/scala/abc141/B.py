s = input()

l = len(s)

ok = True
for i in range(l):
    if i % 2 == 1:
        if s[i] == 'R':
            ok = False
    if i % 2 == 0:
        if s[i] == 'L':
            ok = False

print("Yes" if ok else "No")
