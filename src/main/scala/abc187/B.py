N = int(input())
P = []

for i in range(N):
    x, y = map(int, input().split())
    P.append((x, y))

cnt = 0
for i in range(N):
    for j in range(i + 1, N):
        if P[i][0] - P[j][0] < 0:
            if -(P[i][0] - P[j][0]) >= P[i][1] - P[j][1] >= P[i][0] - P[j][0]:
                cnt += 1
        else:
            if -(P[i][0] - P[j][0]) <= P[i][1] - P[j][1] <= P[i][0] - P[j][0]:
                cnt += 1

print(cnt)