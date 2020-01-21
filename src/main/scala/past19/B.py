N = int(input())

p = int(input())

for _ in range(N - 1):
    c = int(input())

    if c > p:
        print("up", c - p)
    elif c < p:
        print("down", p - c)
    else:
        print("stay")
    p = c