import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
L = list(map(int, input().split()))
N = len(L)

cnt = 0
for i in range(N):
    for j in range(i + 1, N):
        for k in range(j + 1, N):
            if L[i] == L[j] or L[i] == L[k] or L[j] == L[k]:
                continue
            if L[i] < L[j] + L[k] and L[j] < L[k] + L[i] and L[k] < L[i] + L[j]:
                cnt += 1

print(cnt)