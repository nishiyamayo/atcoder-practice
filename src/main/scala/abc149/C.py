X = int(input())

def is_prime(x):
    i = 2
    while i * i <= x:
        if x % i == 0:
            return False
        i += 1
    return True

while not is_prime(X):
    X += 1

print(X)