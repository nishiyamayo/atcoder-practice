import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

c1 = list(map(int, input().split()))
c2 = list(map(int, input().split()))
c3 = list(map(int, input().split()))

def ok(c):
    if c[0][0] - c[0][1] == c[1][0] - c[1][1] == c[2][0] - c[2][1] \
            and c[0][0] - c[0][2] == c[1][0] - c[1][2] == c[2][0] - c[2][2] \
            and c[0][1] - c[0][2] == c[1][1] - c[1][2] == c[2][1] - c[2][2] \
            and c[0][0] - c[1][0] == c[0][1] - c[1][1] == c[0][2] - c[1][2] \
            and c[0][0] - c[2][0] == c[0][1] - c[2][1] == c[0][2] - c[2][2] \
            and c[1][0] - c[2][0] == c[1][1] - c[2][1] == c[1][2] - c[2][2]:
        return True
    return False

print("Yes" if ok([c1, c2, c3]) else "No")