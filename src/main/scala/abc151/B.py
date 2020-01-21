N, K, M = map(int, input().split())

S = sum(list(map(int, input().split())))

if N * M - S <= K:
    print(max(0, N * M - S))
else:
    print(-1)
