N, A, B = map(int, input().split())

c = N // (A + B)

print(c * A + min(A, N - c * (A + B)))