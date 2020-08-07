import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = [input().split() for _ in range(N)]
S = sum(map(lambda x:int(x[1]), A)) // 2

a = list(filter(lambda x: int(x[1]) > S, A))

print(a[0][0] if a else "atcoder")