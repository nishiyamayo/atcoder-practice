S = input()

l = len(S)

cnt = 0
for i in range(l // 2):
    if S[i] != S[~i]:
        cnt += 1

print(cnt)