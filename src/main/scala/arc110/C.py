N = int(input())
P = list(map(lambda x: int(x) - 1, input().split()))
RP = [0] * N
for i, p in enumerate(P):
    RP[p] = i

used = [False] * N

idx = 0

used = [False] * (N - 1)
record = []
ok = True

while ok and idx != N:
    cur = RP[idx]
    # print(cur, idx)
    while ok and cur != idx:
        if cur > idx:
            if used[cur - 1]:
                ok = False
                break
            record.append(cur)
            used[cur - 1] = True
            RP[idx], RP[P[cur - 1]] = RP[idx] - 1, RP[P[cur - 1]] + 1
            P[cur], P[cur - 1] = P[cur - 1], P[cur]

            cur -= 1
        else:
            if used[cur]:
                ok = False
                break
            record.append(cur + 1)
            used[cur] = True
            RP[idx], RP[P[cur + 1]] = RP[idx] + 1, RP[P[cur + 1]] - 1
            P[cur], P[cur + 1] = P[cur + 1], P[cur]

            cur += 1

        # print(P, RP)
    idx += 1

if ok and len(record) == N - 1:
    for ans in record:
        print(ans)
else:
    print(-1)
#
# print(used)