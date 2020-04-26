import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

cnt = [0] * (N + 1)
for a in A:
    cnt[a] += 1

for i in range(1, N + 1):
    print(cnt[i])