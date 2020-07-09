import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

cnt = 0
for i in range(N):
    while A[i] % 2 == 0:
        A[i] //= 2
        cnt += 1

print(cnt)