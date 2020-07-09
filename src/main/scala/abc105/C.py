import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())


ans = []
of = 0


if N < 0:
    N = -N
    s = "0000" + bin(N)[2:]
    l = len(s)
    for i in range(l):
        # 1010 = N + 0101
        of, b = of, int(s[l - i - 1])
        if i % 2 == 0:
            if (of, b) == (0, 0):
                ans.append(0)
                of = 0
            elif (of, b) == (0, 1):
                ans.append(1)
                of = 1
            elif (of, b) == (1, 0):
                ans.append(1)
                of = 1
            else:
                ans.append(0)
                of = 1
        else:
            if (of, b) == (0, 0):
                ans.append(0)
                of = 0
            elif (of, b) == (0, 1):
                ans.append(1)
                of = 0
            elif (of, b) == (1, 0):
                ans.append(1)
                of = 0
            else:
                ans.append(0)
                of = 1
    ans.reverse()
    pre_ans = "".join(list(map(str, ans)))
    print(pre_ans[pre_ans.find("1"):])

elif N > 0:
    s = "0000" + bin(N)[2:]
    l = len(s)

    for i in range(l):
        # 10101 = N + 01010
        of, b = of, int(s[l - i - 1])
        if i % 2 == 0:
            if (of, b) == (0, 0):
                ans.append(0)
                of = 0
            elif (of, b) == (0, 1):
                ans.append(1)
                of = 0
            elif (of, b) == (1, 0):
                ans.append(1)
                of = 0
            else:
                ans.append(0)
                of = 1
        else:
            if (of, b) == (0, 0):
                ans.append(0)
                of = 0
            elif (of, b) == (0, 1):
                ans.append(1)
                of = 1
            elif (of, b) == (1, 0):
                ans.append(1)
                of = 1
            else:
                ans.append(0)
                of = 1
    ans.reverse()
    pre_ans = "".join(list(map(str, ans)))
    print(pre_ans[pre_ans.find("1"):])
else:
    print(0)

#11000101011001101110100010101
#11000101011001101110100010101