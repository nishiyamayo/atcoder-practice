import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = list(input())

def ok(s):
    if S[0] != 'A':
        return False
    if S[-1] == 'C' or S[1] == 'C':
        return False

    if len(list(filter(lambda x : x == 'C', S[2:]))) != 1:
        return False


    if list(map(lambda x: x.lower() if x not in ['A', 'C'] else x, s)) != s:
        return False

    return True

print("AC" if ok(S) else "WA")