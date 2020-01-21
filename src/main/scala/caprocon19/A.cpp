#include <bits/stdc++.h>

#define REP(i,n) for(int i=0;i<(int)(n);i++)
#define ALL(x) (x).begin(),(x).end()

using namespace std;

using ll = long long;
using ld = long double;

template <typename T> T &chmin(T &a, const T &b) { return a = min(a, b); }
template <typename T> T &chmax(T &a, const T &b) { return a = max(a, b); }

struct yes_no : numpunct<char> {
  string_type do_truename()  const { return "Yes"; }
  string_type do_falsename() const { return "No"; }
};

struct UnionFind {
  vector<int> parent;
  UnionFind (int n) : parent(n, -1) {}
  int root(int x) { return parent[x] < 0 ? x : parent[x] = root(parent[x]); }
  bool merge(int x, int y) {
    x = root(x); y = root(y);
    if (x == y) return false;
    if (parent[y] < parent[x]) swap(x, y);
    if (parent[x] == parent[y]) --parent[x];
    parent[y] = x;
    return true;
  }
};

struct Edge{ int src, dest; };

using Edges = vector<Edge>;
using Graph = vector<Edges>;

Edges edges;
vector<vector<int> > connect;
vector<int> roots, st, order;
int cnt;

void bridgeDfs(const Graph &g, int from, int parent) {
  order[from] = cnt++;
  st.push_back(from);
  roots.push_back(from);
  for (Edge e : g[from]) {
    int to = e.dest;
    if (to == parent) continue;
    if (order[to] == -1) {
      bridgeDfs(g, to, from);
    }
    else {
      while (order[roots.back()] > order[to]) roots.pop_back();
    }
  }
  if (from == roots.back()) {
    edges.push_back(Edge{parent, from});
    connect.push_back(vector<int>());
    while (true) {
      int w = st.back();
      st.pop_back();
      connect.back().push_back(w);
      if (from == w) break;
    }
    roots.pop_back();
  }
}

Edges bridge(const Graph &g) {
  const int n = g.size();
  edges.clear(); connect.clear();
  roots.clear(); st.clear(); order.assign(n, -1);
  cnt = 0;
  for (int i = 0; i < n; i++) {
    if (order[i] != -1) continue;
    bridgeDfs(g, i, i);
    edges.pop_back();
  }
  return edges;
}

bool visited[100100];
int A[100100], H[100100];

pair<ll,ll> dfs(const vector<vector<pair<int,int>>>& tree, int v) {
  visited[v] = true;
  pair<ll,ll> res(0, 0);
  for (auto e: tree[v]) {
    if (visited[e.first]) continue;
    auto p = dfs(tree, e.first);
    res.first += p.first;
    res.first += abs(p.second) * e.second;
    res.second += p.second;
    // cout << v << " " << e.first << " " << e.second << " " << p.second << endl;
  }
  res.second += A[v];
  res.second -= H[v];
  return res;
}

char str[100100];

int main() {
  locale loc(locale(), new yes_no);
  cout << boolalpha;
  cout.imbue(loc);
  int T;
  scanf("%d", &T);
  while (T--) {
    int n, m;
    scanf("%d%d", &n, &m);
    UnionFind uf(n);
    scanf("%s", str);
    Graph g(n);
    map<pair<int,int>, int> cost;
    REP(i,m) {
      int l, r, c;
      scanf("%d%d%d", &l, &r, &c);
      --l; --r;
      if (r < l) swap(l, r);
      g[l].push_back((Edge){l, r});
      g[r].push_back((Edge){r, l});
      cost[make_pair(l, r)] = c;
    }
    Edges es = bridge(g);
    vector<vector<pair<int,int>>> tree(n);
    for (auto e: es) {
      int s = e.src, t = e.dest;
      if (s > t) swap(s, t);
      auto p = make_pair(s, t);
      auto it = cost.find(p);
      int c = it->second;
      // cout << s << " " << t << " " << c << endl;
      tree[s].emplace_back(t, c);
      tree[t].emplace_back(s, c);
      bool ok = cost.erase(make_pair(s, t));
      assert (ok);
    }
    REP(i,n) {
      A[i] = 0;
      H[i] = 0;
      visited[i] = false;
    }
    for (auto p: cost) {
      pair<int,int> e = p.first;
      int s = uf.root(e.first);
      int t = uf.root(e.second);
      uf.merge(s, t);
    }
    REP(i,n) {
      if (str[i] == 'H') {
        H[uf.root(i)] += 1;
      }
      else if (str[i] == 'A') {
        A[uf.root(i)] += 1;
      }
      visited[i] = false;
    }
    // REP(i,n) cout << A[i] << " " << H[i] << endl;
    ll res = 0;
    REP(i,n) {
      auto p = dfs(tree, i);
      res += p.first;
    }
    printf("%lld\n", res);
  }
  return 0;
}
