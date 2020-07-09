import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
from typing import Dict, Tuple

N, M = map(int, input().split())
T = []

for i in range(M):
    x, y = map(int, input().split())
    T.append((x - 1, y - 1))


def solve(cur: int, S: int, memo: Dict[Tuple[int, int], int]):
    if S == (1 << N) - 1:
        memo[(cur, S)] = 1 if check(cur, S) else 0
        return memo[(cur, S)]

    if (cur, S) in memo.keys():
        return memo[(cur, S)]

    if not check(cur, S):
        memo[(cur, S)] = 0
        return memo[(cur, S)]


    cnt = 0
    for i in range(N):
        if (S >> i) & 1 == 0:
            cnt += solve(i, S | (1 << i), memo)

    memo[(cur, S)] = cnt
    return cnt


def check(cur: int, S: int) -> bool:
    for t in T:
        x, y = t

        if x == cur:
            if ((S >> y) & 1) == 1:
                return False
        elif y == cur:
            if ((S >> x) & 1) == 0:
                return False

    return True


ans = 0
memo = {}
for i in range(N):
    ans += solve(i, 1 << i, memo)

print(ans)
