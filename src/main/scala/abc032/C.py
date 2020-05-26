import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())
S = [int(input()) for _ in range(N)]

left, right = 0, 0
mult = 1
ans = 0
if min(S) == 0:
    print(len(S))
elif K == 0:
    print(0)
else:
    while right < N:
        while right < N and mult <= K:
            ans = max(ans, right - left)
            mult *= S[right]
            right += 1
        while left < N and mult > K:
            mult //= S[left]
            left += 1
        ans = max(ans, right - left)

    print(ans)