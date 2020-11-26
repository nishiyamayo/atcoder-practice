
N = int(input())

x = 1
ar = []
while x * x < N:
    if N % x == 0:
        ar.append(x)
        ar.append(N // x)
    x += 1

if x ** 2 == N:
    ar.append(x)

ar.sort()
for a in ar:
    print(a)
