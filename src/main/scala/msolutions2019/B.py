# 参考: https://qiita.com/y-tsutsu/items/aa7e8e809d6ac167d6a1

import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

# 多次元配列
# dp = [[0] * 3 for _ in range(5)]

# 入力を受け取る
s = input()

l = len(s)

w = len(list(filter(lambda c: c == 'o', s)))

print('YES' if 15 - l + w >= 8 else 'NO')
