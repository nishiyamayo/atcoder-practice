import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

H, W = map(int, input().split())

ignore = "".join(["." for _ in range(W)])

A = list(filter(lambda x : x != ignore, [input() for _ in range(H)]))
H = len(A)
B = [[] for _ in range(H)]

for w in range(W):
    if list(filter(lambda x: x[w] == "#", A)):
        for i in range(H):
            B[i].append(A[i][w])

for h in range(H):
    print("".join(B[h]))
