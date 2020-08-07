import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

"""
f(Xi)を求めたい
Xi: Xのi bit目をbit反転したもの

i bit目が0のとき
f(Xi) = f(X + (1 << i))
      = (X + (1 << i)) mod popcount(Xi)
      = ( X mod (popcount(X) + 1) + (1 << i) mod (popcount(X) + 1) ) mod (popcount(X) + 1)

i bit目が1のとき
f(Xi) = f(X - (1 << i))
      = (X - (1 << i)) mod popcount(Xi)
      = ( X mod (popcount(X) - 1) - (1 << i) mod (popcount(X) - 1) + (popcount(X) - 1) ) mod (popcount(X) - 1)

f(Xi) < popcount(Xi) ≒ 10^5
"""