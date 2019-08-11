
n = int(input())
A = map(int, input())
B = map(int, input())

bc = [0] * (100000 + 1)

for b in B:
    bc[b] += 1


ac = {}
for a in A:
    pass