import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
use = [False] * 26

for s in S:
    use[ord(s) - 97] = True

def ans():
    for i in range(26):
        if not use[i]:
            return chr(i + 97)

    return "None"

print(ans())