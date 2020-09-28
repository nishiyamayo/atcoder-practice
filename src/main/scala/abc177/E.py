import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))
A.sort()

LEN = 1000000

ps = [[] for _ in range(LEN + 1)]
is_prime = [False] * (LEN + 1)
for i in range(2, LEN + 1):
    if not is_prime[i]:
        for j in range(i, LEN + 1, i):
            is_prime[j] = True
            ps[j].append(i)

def is_pairwise_coprime():
    s = set()
    for a in A:
        for p in ps[a]:
            if p in s:
                return False
            s.add(p)

    return True


def is_otherwise():
    m = min(A)

    for p in ps[m]:
        if all(map(lambda x: x % p == 0, A)):
            return True

    return False

if is_pairwise_coprime():
    print("pairwise coprime")
elif is_otherwise():
    print("not coprime")
else:
    print("setwise coprime")