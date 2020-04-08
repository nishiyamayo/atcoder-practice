import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

cnt = [0] * 100010
for a in A:
    if a > 0:
        cnt[a - 1] += 1
    cnt[a] += 1
    cnt[a + 1] += 1

print(max(cnt))