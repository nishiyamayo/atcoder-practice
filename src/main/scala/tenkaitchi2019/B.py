import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

import re
n,s,k=[input()for _ in "nsk"]
print(re.sub(f"[^{s[int(k)-1]}]","*",s))