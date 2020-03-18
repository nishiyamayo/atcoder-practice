N, M = map(int, input().split())
AB = []
CD = []

class P:
    def __init__(self, f, s):
        self.f = f
        self.s = s

    @classmethod
    def setX(cls, X):
        cls.X = X

    def __lt__(self, other):
        return -(self.s - self.X * self.f) + (other.s - self.X * other.f) < 0

for i in range(N):
    a, b = map(int, input().split())
    AB.append(P(a, b))

for i in range(M):
    c, d = map(int, input().split())
    CD.append(P(c, d))


def ok(x: float):
    P.setX(x)
    CD.sort()
    T = sorted(AB + [CD[0]])
    v = sum(map(lambda x:x.s, T[0:5])) / sum(map(lambda x:x.f, T[0:5]))
    return v >= x

l = 0
r = 1e6
for _ in range(100):
    c = (l + r) / 2
    if (ok(c)):
        l = c
    else:
        r = c

print(l)