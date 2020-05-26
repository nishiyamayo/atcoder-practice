import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
op = ["+", "-"]

def exec():
    for a in op:
        for b in op:
            for c in op:
                exp = S[0:1] + a + S[1:2] + b + S[2:3] + c + S[3:4]
                if eval(exp) == 7:
                    return exp + "=7"

print(exec())