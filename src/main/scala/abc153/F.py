
from heapq import heappop, heappush

N, D, A = map(int, input().split())

def l():
    a, b = map(int, input().split())
    return P(a, b, 0)

class P:
    def __init__(self, f, s, e):
        self.f = f
        self.s = s
        self.e = e

    def __lt__(self, other):
        return self.f > self.f

XA = [l() for _ in range(N)]

XA = sorted(XA)

dm = 0
q = []
for xa in XA:
    heappush(q, xa)

cnt = len(q)
while cnt > 0:
    xa = heappop(q)
for xa in XA:
    if xa.s == 0:
        xa.f -= dm

        pass
    elif xa.s == 1:
        pass
    else:
        pass