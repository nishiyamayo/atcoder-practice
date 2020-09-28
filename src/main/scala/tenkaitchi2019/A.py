import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

a,b,c=map(int,input().split())
print("NYoe s"[a>c>b or a<c<b::2])