import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = int(input())
B = int(input())
C = int(input())
X = int(input())

cnt = 0
for i in range(A + 1):
    for j in range(B + 1):
        for k in range(C + 1):
            if i * 500 + j * 100 + 50 * k == X:
                cnt += 1

print(cnt)