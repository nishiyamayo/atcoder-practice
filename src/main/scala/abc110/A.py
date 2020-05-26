import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

I = list(map(int, input().split()))
I.sort(reverse=True)
print(I[0] * 10 + sum(I[1:3]))