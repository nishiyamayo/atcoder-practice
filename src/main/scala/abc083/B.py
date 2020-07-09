import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, A, B = map(int, input().split())

ans = 0
for i in range(N + 1):
    s = list(str(i))

    cnt = 0
    for x in s:
        cnt += int(x)

    if A <= cnt <= B:
        ans += i

print(ans)