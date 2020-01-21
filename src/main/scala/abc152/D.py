N = int(input())
cnts = [[0] * 10 for _ in range(10)]
ans = 0
for i in range(N + 1):
    if i % 10 == 0:
        continue
    s = str(i)
    cnts[int(s[0])][int(s[-1])] += 1

for i in range(N + 1):
    if i % 10 == 0:
        continue
    s = str(i)
    ans += cnts[int(s[-1])][int(s[0])]

print(ans)
