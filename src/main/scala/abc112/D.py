import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())

i = 1
ans = 0
while i * i <= M:
    if M % i == 0 and M // i >= N:
        ans = max(ans, i)
    if M % i == 0 and M // (M // i) >= N:
        ans = max(ans, M // i)

    i += 1

print(ans)
