import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())
A = list(map(int, input().split()))

for i in range(N - K):
    print("Yes" if A[i + K] > A[i] else "No")