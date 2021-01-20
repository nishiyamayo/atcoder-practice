class SegmentTree:

    def __init__(self, n, fn=lambda x, y: min(x, y), unity=(1 << 31) - 1):
        self.n = 1
        while self.n < n:
            self.n *= 2

        self.arr = [unity] * (2 * self.n - 1)
        self.fn = fn
        self.unity = unity

    def add(self, i, a):
        k = self.n + i - 1
        self.arr[k] += a

        while k > 0:
            k = (k - 1) // 2
            self.arr[k] = self.fn(self.arr[2 * k + 1], self.arr[2 * k + 2])

    def update(self, i, x):
        k = self.n + i - 1
        self.arr[k] = x

        while k > 0:
            k = (k - 1) // 2
            self.arr[k] = self.fn(self.arr[2 * k + 1], self.arr[2 * k + 2])

    def query(self, l, r):
        return self._inner_query(l, r, 0, 0, self.n)

    def _inner_query(self, l, r, k, il, ir):
        if ir <= l or r <= il:
            return self.unity

        elif l <= il and ir <= r:
            return self.arr[k]

        vl = self._inner_query(l, r, k * 2 + 1, il, (il + ir) // 2)
        vr = self._inner_query(l, r, k * 2 + 2, (il + ir) // 2, ir)
        return self.fn(vl, vr)

    def __str__(self):
        return self.arr[0: 2 * self.n].__str__()


H, W, M = map(int, input().split())
XS = [H for _ in range(W)]
YS = [W for _ in range(H)]
XY = [[] for _ in range(H)]

for i in range(M):
    X, Y = map(int, input().split())
    X -= 1
    Y -= 1
    XS[Y] = min(XS[Y], X)
    YS[X] = min(YS[X], Y)
    XY[X].append(Y)

ans = 0
for X in XS:
    if X == 0:
        break
    ans += X

st = SegmentTree(W, lambda x, y: x + y, 0)

for Y in range(YS[0], W):
    st.update(Y, 1)

for idx, Y in enumerate(YS[1:]):
    if Y == 0:
        break
    ans += st.query(0, Y)
    for X in XY[idx + 1]:
        st.update(X, 1)

print(ans)
