import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
L = len(S)

dp = [0] * (L + 1)
pow = [1] * (L + 1)
cnt = [0] * 2019

ans = 0
for i in range(L):
    pow[i + 1] = pow[i] * 10 % 2019
    dp[i + 1] = (dp[i] + int(S[L - i - 1]) * pow[i]) % 2019
    if dp[i + 1] == 0:
        cnt[dp[i + 1]] += 1
        ans += cnt[dp[i + 1]]
    else:
        ans += cnt[dp[i + 1]]
        cnt[dp[i + 1]] += 1

print(ans)