import itertools

N = int(input())
P = list(map(int, input().split()))
Q = list(map(int, input().split()))

T = [i + 1 for i in range(N)]
R = itertools.permutations(T)

def equal(X, Y):
    for x, y in zip(X, Y):
        if x != y:
            return False
    return True

p = -1
q = -1
idx = 0

for r in R:


    if equal(r, P):
        p = idx
    if equal(r, Q):
        q = idx
    idx += 1

print(abs(p - q))
