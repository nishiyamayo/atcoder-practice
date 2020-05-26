import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
S = input()

left = [0] * (N + 2)
right = [0] * (N + 2)

for i in range(N):
    left[i + 1] = left[i] + (1 if S[i] == 'E' else 0)
    right[-i - 2] = right[-i - 1] + (1 if S[-i - 1] == 'W' else 0)

ans = N
for i in range(1, N + 1):
    ans = min(ans, N - left[i] - right[i])

print(ans)