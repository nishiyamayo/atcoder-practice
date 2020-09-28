import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
if S[0] == S[1] == S[2] == "R":
    print(3)
elif S[0:2] == "RR" or S[1:3] == "RR":
    print(2)
elif "R" in S:
    print(1)
else:
    print(0)