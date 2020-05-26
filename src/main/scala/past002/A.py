import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

m = {
    "9F" : 17,
    "8F" : 16,
    "7F" : 15,
    "6F" : 14,
    "5F" : 13,
    "4F" : 12,
    "3F" : 11,
    "2F" : 10,
    "1F" : 9,
    "B1" : 8,
    "B2" : 7,
    "B3" : 6,
    "B4" : 5,
    "B5" : 4,
    "B6" : 3,
    "B7" : 2,
    "B8" : 1,
    "B9" : 0,
}

S, T = input().split()
print(abs(m[S] - m[T]))