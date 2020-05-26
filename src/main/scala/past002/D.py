import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()
l = len(S)

ans = set(["."])

for i in range(l):
    ans.add(S[i])

if l > 1:
    ans.add("..")
    for i in range(l - 1):
        ans.add(S[i:i + 2])
        ans.add(S[i] + ".")
        ans.add("." + S[i + 1])

if l > 2:
    ans.add("...")
    for i in range(l - 2):
        ans.add(S[i:i + 3])

        ans.add(S[i:i + 2] + ".")
        ans.add("." + S[i + 1:i + 3])
        ans.add(S[i] + "." + S[i + 2])

        ans.add(S[i] + "..")
        ans.add("." + S[i + 1] + ".")
        ans.add(".." + S[i + 2])

print(len(ans))