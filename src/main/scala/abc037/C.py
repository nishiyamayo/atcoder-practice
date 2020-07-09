import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy


N, K = map(int, input().split())
A = list(map(int, input().split()))

ans = 0
s = sum(A[:K])

ans = s

for i in range(N - K):
    s += A[K + i] - A[i]
    ans += s

print(ans)