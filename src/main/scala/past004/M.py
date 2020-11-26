from typing import List


class LCA:
    n: int
    log_n: int
    root: int

    par: List[List[int]]
    depth: List[int]

    def __init__(self, n: int, g: List[List[int]]):
        self.n = n
        self.log_n = 0
        nn = 1
        while nn < n:
            self.log_n += 1
            nn <<= 1

        self.par = [[-1] * n for _ in range(self.log_n)]
        self.depth = [0] * n
        self.root = 0

        self._dfs(0, g)

        for k in range(self.log_n - 1):
            for v in range(n):
                if self.par[k][v] < 0:
                    self.par[k + 1][v] = -1
                else:
                    self.par[k + 1][v] = self.par[k][self.par[k][v]]

    def _dfs(self, root: int, g: List[List[int]]):
        stack = [(root, -1, 0)]

        while stack:
            cur, par, dep = stack.pop()
            self.par[0][cur] = par
            self.depth[cur] = dep

            for nx in g[cur]:
                if nx == par:
                    continue
                stack.append((nx, cur, dep + 1))

    def parent(self, v: int):
        if v == self.root:
            return v
        return self.par[0][v]

    def query(self, u: int, v: int):
        if self.depth[u] > self.depth[v]:
            u, v = v, u
        for k in range(self.log_n):
            if (self.depth[v] - self.depth[u]) >> k & 1:
                v = self.par[k][v]

        if u == v:
            return u

        for k in range(self.log_n - 1, -1, -1):
            if self.par[k][u] != self.par[k][v]:
                u = self.par[k][u]
                v = self.par[k][v]

        return self.par[0][u]


class UnionFind:
    _n: int
    _parents: List[int]
    _rank: List[int]

    def __init__(self, n: int):
        self._n = n
        self._parents = [i for i in range(n)]
        self._rank = [1 for _ in range(n)]

    def unite(self, x: int, y: int) -> None:
        px = self.find(x)
        py = self.find(y)

        # 一致していないときはリンクをつける
        if px != py:
            self._link(px, py)

    def _link(self, x: int, y: int):
        if self._rank[x] < self._rank[y]:
            self._parents[x] = y
        elif self._rank[x] > self._rank[y]:
            self._parents[y] = x
        else:
            self._parents[x] = y
            self._rank[y] += 1

    def same(self, x: int, y: int) -> bool:
        px = self.find(x)
        py = self.find(y)
        return px == py

    def find(self, x: int) -> int:
        if self._parents[x] == x:
            return x

        self._parents[x] = self.find(self._parents[x])
        return self._parents[x]


N, Q = map(int, input().split())
G = [[] for _ in range(N)]

ES = []

for i in range(N - 1):
    a, b = map(int, input().split())
    G[a - 1].append(b - 1)
    G[b - 1].append(a - 1)
    ES.append((a - 1, b - 1))

lca = LCA(N, G)
QS = []
for i in range(Q):
    u, v, c = map(int, input().split())
    QS.append((u - 1, v - 1, c))

QS.reverse()

EC = dict()

uf = UnionFind(N)
uf_parent = [i for i in range(N)]


def draw(u: int, par: int, c: int):
    par = uf_parent[par]
    u = uf_parent[uf.find(u)]
    while u != uf_parent[uf.find(par)]:
        p = lca.parent(u)
        h = min(u, p) * 1000000 + max(u, p)
        tmp = uf_parent[uf.find(p)]
        if not h in EC:
            EC[h] = c
            uf.unite(u, p)
            uf_parent[uf.find(u)] = tmp

        u = tmp


for u, v, c in QS:
    par = lca.query(u, v)
    # print(u, v, par, c)
    draw(u, par, c)
    draw(v, par, c)

for a, b in ES:
    if a > b:
        a, b = b, a
    print(EC.get(a * 1000000 + b, 0))
