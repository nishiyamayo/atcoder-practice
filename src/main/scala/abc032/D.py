import sys
import heapq, math
from bisect import bisect, bisect_left, bisect_right
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, WMAX = map(int, input().split())
V, W = [0] * N, [0] * N

cons1 = N <= 30
cons2 = True
cons3 = True

for i in range(N):
    V[i], W[i] = map(int, input().split())
    if V[i] > 1000:
        cons2 = False
    if W[i] > 1000:
        cons3 = False

INF = 1 << 60

if cons1:

    def all_enumurate(S, T):
        L = len(S)

        ret = []
        for i in range(1, 1 << L):
            ws, vs = 0, 0
            for j in range(L):
                if (i >> j) & 1 == 1:
                    ws += S[j]
                    vs += T[j]

            ret.append((ws, vs))

        ret.sort(key=lambda x: x[0])

        f = []
        vl = -1
        for r in ret:
            if vl < r[1]:
                f.append(r)
                vl = r[1]
        return f

    left = [(0, 0)] + all_enumurate(W[:N//2], V[:N // 2])
    right = all_enumurate(W[N//2:], V[N // 2:])
    right_idx = list(map(lambda x:x[0], right))

    ans = 0
    for l in left:
        if WMAX - l[0] < 0:
            continue

        idx = bisect_right(right_idx, WMAX - l[0]) - 1
        if idx < 0:
            ans = max(ans, l[1])
        else:
            ans = max(ans, l[1] + right[idx][1])
    print(ans)

elif cons2:
    MAX = sum(V)
    dp = [INF] * (MAX + 1)
    dp[0] = 0

    for i in range(N):
        for j in range(MAX, V[i] - 1, -1):
            dp[j] = min(dp[j], dp[j - V[i]] + W[i])

    ans = 0
    for j in range(MAX + 1):
        if dp[j] <= WMAX:
            ans = j
    print(ans)
else:
    MAX = sum(W)
    dp = [-1] * (MAX + 1)
    dp[0] = 0

    for i in range(N):
        for j in range(MAX, W[i] - 1, -1):
            if dp[j - W[i]] >= 0:
                dp[j] = max(dp[j], dp[j - W[i]] + V[i])

    ans = 0
    for j in range(min(WMAX, MAX) + 1):
        ans = max(ans, dp[j])
    print(ans)