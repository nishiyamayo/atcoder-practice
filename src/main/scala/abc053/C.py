import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
x = int(input())

cnt = x // 11

if x % 11 == 0:
    print(cnt * 2)
elif cnt * 11 + 6 >= x:
    print(cnt * 2 + 1)
else:
    print(cnt * 2 + 2)