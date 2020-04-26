import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

X = input()
l = len(X)

def ok():
    for i in range(l):
        if X[i] == 'c' and (i + 1 >= l or X[i + 1] != 'h'):
            return False
        if X[i] == 'h' and (i - 1 < 0 or X[i - 1] != 'c'):
            return False
        elif X[i] in "choku":
            pass
        else:
            return False
    return True

print("YES" if ok() else "NO")