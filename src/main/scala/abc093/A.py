import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

print(["No","Yes"][input()in"abcab bacba"])
print(["No","Yes"][len(set(input()))==3])
