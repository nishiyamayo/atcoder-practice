A = int(input())

for i in range(1, 10):
    if A % i == 0:
        if A // i <= 9:
            print("Yes")
            exit(0)
print("No")