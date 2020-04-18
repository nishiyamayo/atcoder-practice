import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B = map(int, input().split())
S = input()

if S[0:A].isdigit() and S[A + 1:].isdigit() and S[A] == "-":
    print("Yes")
else:
    print("No")