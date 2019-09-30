N = int(input())
S = input()

cnt = 0
idx = 0
while idx < N - 1:
    if S[idx] != S[idx + 1]:
        cnt += 1
        idx += 1
    idx += 1

print(cnt)
