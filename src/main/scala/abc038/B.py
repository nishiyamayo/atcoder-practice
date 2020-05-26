import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
H1, W1 = map(int, input().split())
H2, W2 = map(int, input().split())

print("YES" if H1 == H2 or H1 == W2 or W1 == H2 or W1 == W2 else "NO")