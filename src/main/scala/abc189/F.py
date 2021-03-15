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


N, M, K = map(int, input().split())
A = list(map(int, input().split()))
cnt = 1
NG = False
for i in range(1, K):
    if A[i - 1] + 1 == A[i]:
        cnt += 1
    else:
        cnt = 1
    if cnt >= M:
        NG = True
        break
if M == K == 1:
    NG = True
A = set(A)

sta = SegmentTree(N + M, lambda x, y: x + y, 0.)
stb = SegmentTree(N + M, lambda x, y: x + y, 0.)

for i in range(N - 1, -1, -1):
    if i in A:
        sta.update(i, 1)
    else:
        sa = sta.query(i + 1, i + M + 1)
        sta.update(i, sa / M)
        sb = stb.query(i + 1, i + M + 1)
        stb.update(i, sb / M + 1)
        # print(sa, sb, stb.query(i + 1, i + M + 1))

if NG:
    print(-1)
else:
    a = sta.query(0, 1)
    b = stb.query(0, 1)
    # print(M, a, b)
    print(b / (1 - a))
