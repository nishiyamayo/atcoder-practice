X = int(input())

ok = [False for _ in range(100000 + 1)]
ok[0] = True

target = [100, 101, 102, 103, 104, 105]

for x in target:
    for i in range(100000 + 1 - x):
        ok[i + x] |= ok[i]

print(1 if ok[X] else 0)