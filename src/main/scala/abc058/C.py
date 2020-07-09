import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
S = [list(input()) for _ in range(N)]

minimum = [100] * 26
for i in range(N):
    tmp = [0] * 26
    for s in S[i]:
        tmp[ord(s) - ord('a')] += 1

    for j in range(26):
        minimum[j] = min(minimum[j], tmp[j])

ans = []

for i in range(26):
    for j in range(minimum[i]):
        ans.append(chr(i + ord('a')))

print("".join(ans))
