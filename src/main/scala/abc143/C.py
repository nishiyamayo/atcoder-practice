import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
S = input()

cnt = 0
for i in range(N - 1):
    cnt += 1 if S[i] != S[i + 1] else 0

print(cnt + 1)