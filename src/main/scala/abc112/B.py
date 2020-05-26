import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N, T = map(int, input().split())

ans = min(map(lambda t: t[0], filter(lambda t: t[1] <= T, [list(map(int, input().split())) for _ in range(N)] + [[1 << 28, 0]])))

print(ans if ans != 1 << 28 else "TLE")