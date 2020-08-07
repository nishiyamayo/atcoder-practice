import sys
import heapq, math
from bisect import bisect_right
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

B = [A[0]]

for i in range(1, N):
    if A[i - 1] != A[i]:
        B.append(A[i])

N = len(B)


def solve():
    ret = 1000
    l = 0
    while l < N:
        while l < N - 1 and B[l] > B[l + 1]:
            l += 1

        if l == N - 1:
            return ret

        C = [B[l]]
        while l < N - 1 and B[l] < B[l + 1]:
            C.append(B[l + 1])
            l += 1

        cnt = ret // C[0]
        ret -= cnt * C[0]
        ret += cnt * C[-1]

        l += 1
    return ret


print(solve())