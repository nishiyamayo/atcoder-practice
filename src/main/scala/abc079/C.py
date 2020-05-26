import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()

def solve(S):
    for op1 in range(-1, 2, 2):
        for op2 in range(-1, 2, 2):
            for op3 in range(-1, 2, 2):
                if int(S[0]) + op1 * int(S[1]) + op2 * int(S[2]) + op3 * int(S[3]) == 7:
                    return S[0] + ("+" if op1 == 1 else "-") + S[1] + ("+" if op2 == 1 else "-") + S[2] + ("+" if op3 == 1 else "-") + S[3] + "=7"

print(solve(S))