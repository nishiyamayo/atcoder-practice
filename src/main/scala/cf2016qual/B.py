import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, A, B = map(int, input().split())
S = input()

for s in S:
    if s == 'a' and A + B > 0:
        print("Yes")
        if A > 0:
            A -= 1
        else:
            B -= 1
    elif s == 'b' and B > 0:
        print("Yes")
        B -= 1
    else:
        print("No")