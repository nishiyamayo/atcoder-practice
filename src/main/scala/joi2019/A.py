a, b, c = map(int, input().split())

if len(list(filter(lambda x: x == 1, [a, b, c]))) >= 2:
    print(1)
else:
    print(2)