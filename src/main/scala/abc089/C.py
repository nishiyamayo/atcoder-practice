import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())

m = {}

for i in range(N):
    s = input()
    if s[0] not in "MARCH":
        continue

    m[s[0]] = m.get(s[0], 0) + 1

ans = 0
for i in range(5):
    for j in range(i + 1, 5):
        for k in range(j + 1, 5):
            ans += m.get("MARCH"[i], 0) * m.get("MARCH"[j], 0) * m.get("MARCH"[k], 0)

print(ans)