import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = input()


if int(N[-1]) in [2,4,5,7,9]:
    print("hon")
elif int(N[-1]) in [0, 1, 6, 8]:
    print("pon")
else:
    print("bon")