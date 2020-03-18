N, K = map(int, input().split())
A = list(map(int, input().split()))
A = list(reversed(sorted(A)))

k = N if N <= K else K
T = A[k:]
print(sum(T))