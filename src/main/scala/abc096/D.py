import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy


def primes():

    MAX = 60000
    prime = [False] * MAX
    prime[0] = prime[1] = True
    i = 2
    ret = []

    while i < MAX:
        if not prime[i]:
            if i % 5 == 1:
                ret.append(i)
            j = 2 * i
            while j < MAX:
                prime[j] = True
                j += i
        i += 1

    return ret

N = int(input())
print(*primes()[:N])