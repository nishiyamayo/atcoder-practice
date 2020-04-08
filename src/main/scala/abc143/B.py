import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
D = list(map(int, input().split()))

ans = 0
for i in range(N):
    for j in range(i + 1, N):
        ans += D[i] * D[j]

print(ans)