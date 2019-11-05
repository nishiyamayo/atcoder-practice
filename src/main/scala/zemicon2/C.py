
n = int(input())
A = list(map(int, input().split()))

c = 0

def dividable(A):
    for a in A:
        if a % 2 != 0:
            return False
    return True

def divide(A):
    return [a // 2 for a in A]

while dividable(A):
    A = divide(A)
    c += 1

print(c)