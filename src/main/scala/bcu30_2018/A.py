n = input()

ages = [0] * 30

for a in (map(int, input().split())):
    ages[a] += 1

print(*ages)
