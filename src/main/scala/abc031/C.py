import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

N = int(input())
A = list(map(int, input().split()))

ans = -1000000000
for i in range(N):
    aoki = -1000000000
    takahashi = -1000000000
    for j in range(N):
        if i == j:
            continue
        elif i < j:
            if aoki < sum(A[i:j + 1][1::2]):
                aoki = sum(A[i:j + 1][1::2])
                takahashi = sum(A[i:j + 1][::2])
        else:
            if aoki < sum(A[j:i + 1][1::2]):
                aoki = sum(A[j:i + 1][1::2])
                takahashi = sum(A[j:i + 1][::2])
    ans = max(ans, takahashi)

print(ans)