import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
S = input()

wc = 0
rc = N - 1

cnt = 0
while True:
    while wc < N and S[wc] == "R":
        wc += 1

    while rc >= 0 and S[rc] == "W":
        rc -= 1

    if wc == N or rc == -1 or wc > rc:
        break

    cnt += 1
    wc += 1
    rc -= 1

print(cnt)