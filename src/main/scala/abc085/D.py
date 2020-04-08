import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
N, H = map(int, input().split())
A = []
B = []

for i in range(N):
    a, b = map(int, input().split())
    A.append(a)
    B.append(b)
a = max(A)
B.sort(reverse=True)

s = (H + a - 1)
ans = s // a
for i in range(N):
    s -= B[i]
    s = max(0, s)
    ans = min(ans, s // a + i + 1)

print(ans)