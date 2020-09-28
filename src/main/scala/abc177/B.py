import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
T = input()

l = len(S)
m = len(T)
ans = 1 << 28
for i in range(l - m + 1):
    cnt = 0
    for j in range(m):
        if S[i + j] != T[j]:
            cnt += 1
    ans = min(ans, cnt)

print(ans)