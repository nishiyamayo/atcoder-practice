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
S = input()
Q = int(input())

segs = [SegmentTree(N, lambda x, y: x + y, 0) for _ in range(26)]

L = len(S)

for i in range(L):
    x = ord(S[i]) - 97
    segs[x].update(i, 1)

for i in range(Q):
    m, a, b = input().split()

    if m == "1":
        a = int(a) - 1
        b = ord(b) - 97
        for i in range(26):
            segs[i].update(a, 0)
        segs[b].update(a, 1)
    else:
        a = int(a) - 1
        b = int(b)
        cnt = 0
        for i in range(26):
            cnt += 1 if segs[i].query(a, b) > 0 else 0
        print(cnt)