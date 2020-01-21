N, M = map(int, input().split())

ac = [False] * N
pe = [0] * N
cnt = 0

for _ in range(M):
    p, s = input().split()
    p = int(p) - 1

    if ac[p]:
        continue

    if s == 'AC':
        ac[p] = True
        cnt += pe[p]
    else:
        pe[p] += 1

print(sum(ac), cnt)