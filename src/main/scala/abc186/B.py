import itertools

H, W = map(int, input().split())
A = list(itertools.chain.from_iterable([list(map(int, input().split())) for _ in range(H)]))

minimum = min(A)
print(sum(map(lambda x: x - minimum, A)))