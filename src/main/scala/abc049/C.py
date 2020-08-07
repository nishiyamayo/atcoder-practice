import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

S = input()

i = len(S)
ok = True

while ok and i > 0:
    if i - 7 >= 0 and S[i - 7:i] == "dreamer":
        i = i - 7
    elif i - 5 >= 0 and S[i - 5:i] == "dream":
        i = i - 5
    elif i - 6 >= 0 and S[i - 6:i] == "eraser":
        i = i - 6
    elif i - 5 >= 0 and S[i - 5:i] == "erase":
        i = i - 5
    else:
        ok = False

print("YES" if i == 0 else "NO")
