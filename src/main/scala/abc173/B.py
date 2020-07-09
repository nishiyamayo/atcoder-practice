import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = [input() for _ in range(N)]

print(f"AC x {len(list(filter(lambda x: x == 'AC', A)))}")
print(f"WA x {len(list(filter(lambda x: x == 'WA', A)))}")
print(f"TLE x {len(list(filter(lambda x: x == 'TLE', A)))}")
print(f"RE x {len(list(filter(lambda x: x == 'RE', A)))}")