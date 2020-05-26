import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(lambda x: int(x) - 1, input().split()))
B = []

def f(i):
    x = A[i]
    cnt = 1
    while x != i:
        x = A[x]
        cnt += 1
    return cnt

for i in range(N):
    B.append(f(i))

print(*B)
