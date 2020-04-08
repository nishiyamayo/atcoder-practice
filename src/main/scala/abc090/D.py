import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, K = map(int, input().split())

if K == 0:
    print(N * N)
else:
    ans = 0
    for i in range(K + 1, N + 1):
        cnt = N // i
        x = max(0, N - cnt * i - K + 1)
        ans += (cnt + 1) * x
        ans += cnt * (i - K - x)

        # cnt = N // i
        # for j in range(K, N - cnt * i):
        #     ans += cnt + 1
        #
        # for j in range(N - cnt * i, i):
        #     ans += cnt
        #
        # for j in range(K, i):
        #
        #     if cnt * i + j <= N:
        #         cnt += 1
        #     ans += cnt
        # print(i, cnt, x, ans)
    print(ans)