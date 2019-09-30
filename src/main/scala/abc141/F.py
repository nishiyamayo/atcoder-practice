from functools import reduce

MAX_DIGIT = 60

N = int(input())
A = list(map(int, input().split()))

xorsum = reduce(lambda x, y: x ^ y, A)

A = [xor & ~xorsum for xor in A]

rank = 0
for digit in range(59, -1, -1):
    if (xorsum >> (MAX_DIGIT - digit - 1)) & 1 == 1:
        continue

    if rank >= N:
        break
    for j in range(rank, N):
        if A[j] & (1 << digit):
            break

    if j == N:
        continue

    if j > rank:
        A[rank] ^= A[j]

    for j in range(rank + 1, N):
        A[j] = min(A[j], A[j] ^ A[rank])

    rank += 1

x = 0
for i in range(N):
    x = max(x, x ^ A[i])

print(x * 2 + xorsum)
