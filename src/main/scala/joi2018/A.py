A, B, C = map(int, input().split())

idx = -1
for idx in range(1, 10000000):
    if idx % 7 == 0:
        C -= B
    C -= A

    if C <= 0:
        break

print(idx)
