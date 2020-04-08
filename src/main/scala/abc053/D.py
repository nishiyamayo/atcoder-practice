import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

B = [0] * 100001
for a in A:
    B[a] += 1
cnt1 = 0
ans = 0
for b in B:
    if b > 1 and b % 2 == 0:
        cnt1 += 1
    if b > 0:
        ans += 1
if cnt1 % 2 == 1:
    ans -= 1
print(ans)