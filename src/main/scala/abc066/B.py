import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()

l = len(S)

S = S[:-1] if l % 2 != 0 else S[:-2]

for i in range(l // 2):
    if S[:l // 2 - i] == S[l // 2 - i:l - 2 * i]:
        print(l - 2 * i)
        break