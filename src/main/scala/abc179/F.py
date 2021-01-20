
class SegmentTree:


    def __init__(self, n, fn=lambda x, y: min(x, y), unity=(1 << 31) - 1):
        self.n = 1
        while self.n < n:
            self.n *= 2

        self.arr = [unity] * (2 * self.n - 1)
        self.fn = fn
        self.unity = unity

        self.lazy = [unity] * (2 * self.n - 1)
        self.flag = [False] * (2 * self.n - 1)


    def update(self, i, x):
        k = self.n + i - 1
        self.arr[k] = x

        while k > 0:
            k = (k - 1) // 2
            self.arr[k] = self.fn(self.arr[2 * k + 1], self.arr[2 * k + 2])

    def range_update(self, a, b, x):
        self._range_update(a, b, x, 0, 0, self.n)

    def _range_update(self, a, b, x, k, l, r):
        self._eval(k, l, r)

        if r <= a or b <= l:
            return
        elif a <= l and r <= b:
            self.flag[k] = True
            self.lazy[k] = self.fn(x, self.lazy[k])
            self._eval(k, l, r)
        else:
            self._range_update(a, b, x, 2 * k + 1, l, (l + r) // 2)
            self._range_update(a, b, x, 2 * k + 2, (l + r) // 2, r)
            self.arr[k] = self.fn(self.arr[2 * k + 1], self.arr[2 * k + 2])

    def _eval(self, k, l, r):
        if self.flag[k]:
            self.arr[k] = self.fn(self.lazy[k], self.arr[k])
            if l + 1 < r:
                self.lazy[2 * k + 1] = min(self.lazy[2 * k + 1], self.lazy[k])
                self.lazy[2 * k + 2] = min(self.lazy[2 * k + 2], self.lazy[k])
                self.flag[2 * k + 1] = self.flag[2 * k + 2] = True
            self.flag[k] = False

    def query(self, l, r):
        return self._inner_query(l, r, 0, 0, self.n)

    def _inner_query(self, l, r, k, il, ir):
        self._eval(k, il, ir)
        if ir <= l or r <= il:
            return self.unity

        elif l <= il and ir <= r:
            return self.arr[k]

        vl = self._inner_query(l, r, k * 2 + 1, il, (il + ir) // 2)
        vr = self._inner_query(l, r, k * 2 + 2, (il + ir) // 2, ir)
        return self.fn(vl, vr)

    def __str__(self):
        return self.arr[0: 2 * self.n].__str__()

N, Q = map(int, input().split())
sth = SegmentTree(N + 10, unity=N)
stv = SegmentTree(N + 10, unity=N)

cnt = 0
for i in range(Q):
    t, x = map(int, input().split())

    if t == 1:
        y = stv.query(x, x + 1)
        sth.range_update(1, y, x)
        cnt += y - 1 - 1
    else:
        y = sth.query(x, x + 1)
        stv.range_update(1, y, x)
        cnt += y - 1 - 1

print((N - 2) * (N - 2) - cnt)
