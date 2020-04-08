import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
L = len(S)
a = -1
for i in range(L):
    if S[i] == 'A':
        a = i
        break

z = -1
for i in range(L):
    if S[-(i + 1)] == 'Z':
        z = i
        break

print(L - z - a)