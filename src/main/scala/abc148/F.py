import sys
sys.setrecursionlimit(1000000)
N, u, v = map(int, input().split())
u -= 1
v -= 1

G = [[] for _ in range(N)]
elens = [0] * N

for _ in range(N - 1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    G[a].append(b)
    G[b].append(a)
    elens[a] += 1
    elens[b] += 1
depths = [0] * N
dists = [0] * N


TAKAHASHI = [0] * N
AOKI = [0] * N

def dfs_aoki(cur: int, past: int, d: int):
    AOKI[cur] = d

    for nx in G[cur]:
        if nx == past:
            continue
        dfs_aoki(nx, cur, d + 1)

def dfs_takahashi(cur: int, past: int, d: int):
    TAKAHASHI[cur] = d

    for nx in G[cur]:
        if nx == past:
            continue
        dfs_takahashi(nx, cur, d + 1)

dfs_takahashi(u, -1, 0)
dfs_aoki(v, -1, 0)

ans = 0

for i in range(N):
    if TAKAHASHI[i] < AOKI[i]:
        ans = max(ans, AOKI[i] - 1)

print(ans)