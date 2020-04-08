import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

n = int(input())
S = input()

if n % 2 == 1:
    print("No")
else:
    print("Yes" if S[0:n // 2] == S[n // 2:n] else "No")