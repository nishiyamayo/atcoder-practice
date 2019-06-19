n, m = map(int, input().split())

def solve(n: int, m: int) -> (int, int, int):
    for x in range(0, n + 1):
        z = m - 3 * n + x
        y = 4 * n - m - 2 * x
        if y >= 0 and z >= 0:
            return x, y, z

    return -1, -1, -1

x, y, z = solve(n, m)
print(x, y, z)
