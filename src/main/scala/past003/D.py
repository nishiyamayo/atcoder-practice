import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy

nums = """.###..#..###.###.#.#.###.###.###.###.###.
.#.#.##....#...#.#.#.#...#.....#.#.#.#.#.
.#.#..#..###.###.###.###.###...#.###.###.
.#.#..#..#.....#...#...#.#.#...#.#.#...#.
.###.###.###.###...#.###.###...#.###.###.
""".split()

num_obj = []

for i in range(10):
    num = [nums[j][4 * i + 1: 4 * (i + 1)] for j in range(5)]
    num_obj.append(num)

N = int(input())

S = [input() for _ in range(5)]

ans = []
for i in range(N):
    x = [S[j][4 * i + 1: 4 * (i + 1)] for j in range(5)]

    for j in range(10):
        eq = True
        for k in range(5):
            eq &= x[k] == num_obj[j][k]

        if eq:
            ans.append(j)
            break

print("".join(map(str, ans)))