import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

if len(list(filter(lambda v : v == 0, A))) > 0:
    print(0)
else:

    x = 1
    MAX = 10 ** 18
    for a in A:
        x *= a
        if x > MAX:
            x = -1
            break

    print(x)