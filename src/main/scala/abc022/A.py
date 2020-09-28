import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N,S,T=map(int,input().split())
A=[int(input()) for _ in range(N)]
print([S<=sum(A[0:i+1])<=T for i in range(N)].count(True))
