import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
T = input()

s = [[] for _ in range(26)]
t = [[] for _ in range(26)]

l = len(S)

for i in range(l):
    s[ord(S[i]) - ord('a')].append(i)
    t[ord(T[i]) - ord('a')].append(i)


def ok():
    ch = [False] * 26
    for i in range(l):
        if not ch[ord(S[i]) - ord('a')]:
            ch[ord(S[i]) - ord('a')] = True
            ls = s[ord(S[i]) - ord('a')]
            lt = t[ord(T[i]) - ord('a')]
            if ls != lt:
                return False
    return True

print("Yes" if ok() else "No")