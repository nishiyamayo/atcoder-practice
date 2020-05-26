import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

A, B, H, M = map(int, input().split())

RA = (H * 60 + M) / 720 * 360
RB = M / 60 * 360

rad = abs(RA - RB)

sq = A ** 2 + B ** 2 - 2 * A * B * math.cos(math.radians(rad))

print(abs(math.sqrt(sq)))