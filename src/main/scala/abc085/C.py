
def solve(n, y):
    for a in range(n + 1):
        for b in range(n - a + 1):
            if a * 10 + b * 5 + (n - a - b) == y / 1000:
                print("{} {} {}".format(a, b, n - a - b))
                return

    print("-1 -1 -1")
    return

n, y = map(int, input().split())
solve(n, y)
