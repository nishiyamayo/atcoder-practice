import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
from typing import List

N, K = map(int, input().split())
P = list(map(int, input().split()))
C = list(map(int, input().split()))


def solve(N: int, K: int, P: List[int], C: List[int]):
    ans = max(C)
    visited = [False] * N
    for i in range(N):
        if visited[i]:
            continue

        cycle = []
        to = i
        while not visited[to]:
            visited[to] = True
            cycle.append(C[to])
            to = P[to] - 1

        ans = max(ans, partial_solve(len(cycle), K, cycle))

    return ans


def partial_solve(N: int, K: int, A: List[int]):
    ret = max(A)
    B = [0] * (3 * N + 1)
    for i in range(1, 3 * N + 1):
        B[i] = B[i - 1] + A[(i - 1) % N]

    if N > K:
        for l in range(1, N + 1):
            for r in range(l, l + K):
                ret = max(ret, B[r] - B[l - 1])

    else:
        if B[N] < 0:
            K = N
            for l in range(1, N + 1):
                for r in range(l, l + K):
                    ret = max(ret, B[r] - B[l - 1])
        else:
            cnt = K // N - 1

            K = K % N + N

            for l in range(1, N + 1):
                for r in range(l, l + K):
                    ret = max(ret, B[r] - B[l - 1])

            ret += cnt * B[N]

    return ret

print(solve(N, K, P, C))

# N <= 5000
# K = 2
# idx    1   2   3   4   5
# to     2   4   1   5   3
# score  3   4 -10  -8   8
#
# 1 -> 2 -> 4 -> 5 -> 3 -> 1 -> ...

# N < Kのとき、ループ分は省略化
# -> ループしたときのスコアをループ回数掛け合わせて足せば良い

# K <= N のときだけ考えれば良さそう？

# 考察
# - ループが複数あることがある
# - ループの和が負になる
#   -> ループさせない
# - 累積和を使えば良さそう
#   -> どう使う？
#   -> 始点を決めて、1~K回までの合計値の最大を求めれば良い
#   -> O(N * K) => O(N * N)で収められそう！

# ループさせない（順列が与えられない）場合はどうとけば良い？
# K = 2
# idx    1   2   3   4   5   1   2   3   4   5
# to     1   2   3   4   5   1   2   3   4   5
# score  3   4 -10  -8   8   3   4 -10  -8   8
# 最大区間和問題
# ループ => 数列を2倍する

# S * (N / S) * (N / S) = N^2 / S
# ∴ 全体で1個のループの時が計算量最大
