

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


def compress(ar):
    n = len(ar)

    sorted_ar = sorted(set(ar))
    zip = {}
    i = 0
    for x in sorted_ar:
        zip[x] = i
        i += 1



    return [zip[a] for a in ar]

n = int(input())
x = [0] * n
y = [0] * n

for i in range(n):
    x[i], y[i] = map(int, input().split())

cx = compress(x)
cy = compress(y)

cxy = sorted(zip(cx, cy))

st1 = SegmentTree(n, lambda a, b: a + b, 0)
st2 = SegmentTree(n, lambda a, b: a + b, 0)

for i in range(n):
    st2.add(cxy[i][1], 1)

MOD = 998244353
cnt = 0

for i in range(n):
    st1.add(cxy[i][1], 1)
    st2.add(cxy[i][1], -1)
    y1s, y1l = st1.query(0, cxy[i][1]), st1.query(cxy[i][1] + 1, n)
    y2s, y2l = st2.query(0, cxy[i][1]), st2.query(cxy[i][1] + 1, n)

    cnt = (cnt + (y1s + 1) * (y2l + 1)) % MOD
    cnt = (cnt + (y1l + 1) * (y2s + 1)) % MOD

print(cnt)