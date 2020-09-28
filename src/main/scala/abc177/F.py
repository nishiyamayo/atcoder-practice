import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

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
            self.lazy[k] = x
            self._eval(k, l, r)
        else:
            self._range_update(a, b, x, 2 * k + 1, l, (l + r) // 2)
            self._range_update(a, b, x, 2 * k + 2, (l + r) // 2, r)
            self.arr[k] = self.fn(self.arr[2 * k + 1], self.arr[2 * k + 2])

    def _eval(self, k, l, r):
        if self.flag[k]:
            self.arr[k] = self.lazy[k]
            if l + 1 < r:
                self.lazy[2 * k + 1] = self.lazy[2 * k + 2] = self.lazy[k]
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


H, W = map(int, input().split())


l, r = 0, W
A, B = [0] * H, [0] * H

st = SegmentTree(W)
st.range_update(0, W, 1)

for i in range(H):
    A[i], B[i] = map(int, input().split())
    st.range_update(A[i] - 1, B[i], B[i] + 1)
    print(A[i] -1, B[i], st.arr)
    ans = st.query(0, W)
    print(ans + i if ans <= W else -1)
