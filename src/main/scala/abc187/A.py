A, B = input().split()

x = 0
for a in A:
    x += int(a)

y = 0
for b in B:
    y += int(b)

print(max(x, y))