import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

MAX = 100010
ps = [True] * MAX
ps[0] = ps[1] = False

def prime():
    for i in range(2, MAX):
        if ps[i]:
            j = 2 * i
            while j < MAX:
                ps[j] = False
                j += i

cs = [0] * MAX
def cnt():
    for i in range(1, MAX):
        if i % 2 == 1 and ps[i] and ps[(i + 1) // 2]:
            cs[i] = cs[i - 1] + 1
        else:
            cs[i] = cs[i - 1]

prime()
cnt()

Q = int(input())

for i in range(Q):
    l, r = map(int, input().split())
    print(cs[r] - cs[l - 1])