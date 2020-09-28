import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X, K, D = map(int, input().split())


def solve(X, K, D):
    X = abs(X)

    cnt = X // D

    if cnt > K:
        return abs(X - D * K)
    else:
        X -= cnt * D
        K -= cnt

        if K % 2 == 0:
            return X
        else:
            return abs(X - D)


print(solve(X, K, D))