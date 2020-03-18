A, B = map(int, input().split())

def ans():

    for x in range(0, 100000):
        if A == int(x * 0.08) and B == int(x * 0.1):
            print(x)
            return
    print(-1)

ans()