import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()

def gen(s):
    l = len(s)

    for i in range(1, l):
        c = int(s[0: i])
        for v in gen(s[i:]):
            yield c + v

    yield int(s)

print(sum(gen(S)))