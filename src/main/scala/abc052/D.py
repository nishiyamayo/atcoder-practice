import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, A, B = map(int, input().split())
X = list(map(int, input().split()))

ans = 0
for i in range(1, N):
    ans += min((X[i] - X[i - 1]) * A, B)

print(ans)