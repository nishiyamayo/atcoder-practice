
max_v = 10 ** 18

max_2 = 0
max_3 = 0
max_5 = 0
cnt = 0

for i in range(60):
    for j in range(60):
        for k in range(60):
            v = (2 ** i) * (3 ** j) * (5 ** k)
            if max_v < v:
                continue
            max_2 = max(max_2, i)
            max_3 = max(max_3, j)
            max_5 = max(max_5, k)
            cnt += 1

print(max_2, max_3, max_5, cnt)
print(max_2 * max_3 * max_5 * 100)
