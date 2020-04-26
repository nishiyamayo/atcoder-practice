import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, M = map(int, input().split())
A = [input() for _ in range(N)]
B = [input() for _ in range(M)]

ans = False
for ha in range(N):
    for wa in range(N):
        flag = True
        for hb in range(M):
            for wb in range(M):
                if ha + hb >= N or wa + wb >= N:
                    flag = False
                    continue
                if A[ha + hb][wa + wb] != B[hb][wb]:
                    flag = False

        ans |= flag

print("Yes" if ans else "No")