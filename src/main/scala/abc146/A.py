
import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

# 多次元配列
# dp = [[0] * 3 for _ in range(5)]
d = {"SUN":7,"MON":6,"TUE":5,"WED":4,"THU":3,"FRI":2,"SAT":1}
# 入力を受け取る
print(d[input()])
