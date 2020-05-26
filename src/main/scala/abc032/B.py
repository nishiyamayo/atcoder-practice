import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
K = int(input())
s = set()

for i in range(len(S) - K + 1):
    s.add(S[i : i + K])
print(len(s))