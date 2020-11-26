
N, K = map(int, input().split())
K -= 1
d = dict()

for i in range(N):
    S = input()
    d[S] = d.get(S, 0) + 1

l = d.items()
l = sorted(l, key=lambda x:x[1], reverse=True)

if len(l) == 1 and K == 0:
    print(l[K][0])
elif K == 0:
    print(l[K][0] if l[K + 1][1] != l[K][1] else "AMBIGUOUS")
elif K == len(l) - 1:
    print(l[K][0] if l[K - 1][1] != l[K][1] else "AMBIGUOUS")
else:
    print(l[K][0] if l[K - 1][1] != l[K][1] and l[K + 1][1] != l[K][1] else "AMBIGUOUS")
