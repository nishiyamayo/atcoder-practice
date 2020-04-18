import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

cnt2 = 0
cnt4 = 0

for a in A:
    if a % 4 == 0:
        cnt4 += 1
    elif a % 2 == 0:
        cnt2 += 1

if cnt2 // 2 + cnt4 >= N // 2:
    print("Yes")
else:
    print("No")