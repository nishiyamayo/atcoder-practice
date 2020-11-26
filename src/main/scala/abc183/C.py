import itertools
N, K = map(int, input().split())

T = [list(map(int, input().split())) for _ in range(N)]

L = list(range(N))

ans = 0
for l in itertools.permutations(L):
    if not l[0] == 0:
        continue
    s = 0
    for i in range(1, N):
        s += T[l[i - 1]][l[i]]
    s += T[l[-1]][l[0]]
    if s == K:
        ans += 1

print(ans)