N = int(input())

cnt = 0
for i in range(1, N + 1):
    if "7" not in f"{i}" and "7" not in f"{oct(i)}":
        cnt += 1

print(cnt)