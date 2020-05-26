import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A = input()
B = input()

if len(A) != len(B):
    print("GREATER" if len(A) > len(B) else "LESS")
else:
    def lt(A, B):
        l = len(A)
        for i in range(l):
            if A[i] > B[i]:
                return "GREATER"
            elif A[i] < B[i]:
                return "LESS"
        return "EQUAL"

    print(lt(A, B))