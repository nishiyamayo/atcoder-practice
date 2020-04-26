import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
T = input()
sl = len(S)
tl = len(T)

def f(idx):
    if idx + tl > sl:
        return False
    for i in range(tl):
        if S[idx + i] != '?' and S[idx + i] != T[i]:
            return False

    ret = [''] * sl
    for i in range(sl):
        ret[i] = T[i - idx] if idx <= i < idx + tl else S[i] if S[i] != '?' else 'a'

    return "".join(ret)

def solve():
    for i in range(sl, -1, -1):
        if f(i):
            print(f(i))
            return

    print("UNRESTORABLE")

solve()