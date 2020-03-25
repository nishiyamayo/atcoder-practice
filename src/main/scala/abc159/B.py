
import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

# 多次元配列
# dp = [[0] * 3 for _ in range(5)]

# 入力を受け取る
S = input()
l = len(S)

def ok(S):
    for i in range(l):
        if S[i] != S[l - i - 1]:
            return False

    for i in range((l - 1) // 2):
        if S[i] != S[l // 2 - i - 1]:
            return False
        if S[l // 2 + 1 + i] != S[l - i - 1]:
            return False

    return True

print("Yes" if ok(S) else "No")


