import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, V = map(int, input().split())
B, W = map(int, input().split())
T = int(input())

if A < B:
    print("YES" if A + T * V >= B + T * W else "NO")
else:
    print("YES" if A - T * V <= B - T * W else "NO")
