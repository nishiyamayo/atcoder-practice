import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()

if S[2] == S[3] and S[4] == S[5]:
    print("Yes")
else:
    print("No")