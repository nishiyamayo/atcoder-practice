
N = int(input())

def solve(N):
    for i in range(N + 1):
        if int(i * 1.08) == N:
            return i
    return ":("
print(solve(N))