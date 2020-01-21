N = int(input())

A = [list(map(str, input().split())) for _ in range(N)]

X = input()

s = 0
start = False
for ar in A:
    if start:
        s += int(ar[1])

    if ar[0] == X:
        start = True

print(s)