S = input()
n = len(S)
cnt = [0] * n
i = 0
while True:
    rc = 0
    lc = 0

    while i < n and S[i] == 'R':
        rc += 1
        i += 1
    while i < n and S[i] == 'L':
        lc += 1
        i += 1
    cnt[i - lc - 1] = (rc + 1) // 2 + lc // 2
    cnt[i - lc] = rc // 2 + (lc + 1) // 2

    if i == n:
        break

print(*cnt)
