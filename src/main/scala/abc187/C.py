
N = int(input())
d = {}

for i in range(N):
    S = input()
    if S.startswith("!"):
        d[S[1:]] = d.get(S[1:], 0) | 2
    else:
        d[S] = d.get(S, 0) | 1

ok = False
for s, v in d.items():
    if v == 3:
        print(s)
        ok = True
        break

if not ok:
    print("satisfiable")