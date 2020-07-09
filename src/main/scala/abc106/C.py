import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = list(input())
K = int(input())


def ans():
    for i in range(K):
        if S[i] != '1':
            return S[i]

    return '1'


print(ans())
