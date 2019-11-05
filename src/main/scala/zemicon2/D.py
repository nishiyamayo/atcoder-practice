
n = int(input())
A = list(map(int, input().split()))

S = {}

for a in A:
    S[a] = S.get(a, 0) + 1

cnt = 0
for k, v in S.items():
    if k > v:
        cnt += v
    else:
        cnt += min(v, v - k)

print(cnt)