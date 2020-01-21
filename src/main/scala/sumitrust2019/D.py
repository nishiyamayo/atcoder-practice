
class SegmentTree:

    def __init__(self, n, fn=lambda x, y: min(x, y), unity=(1 << 31) - 1):
        self.n = 1
        while self.n < n:
            self.n *= 2

        self.arr = [unity] * (2 * self.n - 1)
        self.fn = fn
        self.unity = unity

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

N = int(input())
S = list(input())

sts = [SegmentTree(N + 1, fn=lambda x, y: max(x, y), unity=0) for _ in range(10)]

minmax = [(N + 1, 0) for _ in range(10)]

for i in range(N):
    c = int(S[i])
    sts[c].update(i, 1)
    minmax[c] = (min(minmax[c][0], i), max(minmax[c][1], i))

cnt = 0
for l in range(10):
    for r in range(10):
        for c in range(10):
            if sts[c].query(minmax[l][0] + 1, minmax[r][1]) > 0:
                cnt += 1
print(cnt)