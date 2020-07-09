import sys
import heapq, math
from itertools import zip_longest, permutations, combinations, combinations_with_replacement
from itertools import accumulate, dropwhile, takewhile, groupby
from functools import lru_cache
from copy import deepcopy
from typing import Dict

K, N = map(int, input().split())
V, W = [], []

for i in range(N):
    v, w = input().split()
    V.append(list(v))
    W.append(list(w))


def check_and_set(k: str, v: str, dic: Dict[int, str]):
    if int(k) in dic.keys() and dic[int(k)] != v:
        return False

    dic[int(k)] = v
    return True


def solve(idx: int, curv: int, curw: int, dic: Dict[int, str]):
    # print(idx, curv, curw, dic)

    if idx == N:
        return dic

    if int(V[idx][curv]) in dic.keys():
        w = dic[int(V[idx][curv])]
        # print(w, "".join(W[idx][curw:]), "".join(W[idx][curw:]).startswith(w))
        if "".join(W[idx][curw:]).startswith(w):
            if curv == len(V[idx]) -1:
                if curw + len(w) == len(W[idx]):
                    return solve(idx + 1, 0, 0, dic)
                else:
                    return False
            else:
                return solve(idx, curv + 1, curw + len(w), dic)
        else:
            return False

    if curv < len(V[idx]) - 1:
        if curw + 1 <= len(W[idx]) and check_and_set(V[idx][curv], "".join(W[idx][curw: curw + 1]), dic):
            if solve(idx, curv + 1, curw + 1, dic):
                return dic
            del dic[int(V[idx][curv])]
        if curw + 2 <= len(W[idx]) and check_and_set(V[idx][curv], "".join(W[idx][curw: curw + 2]), dic):
            if solve(idx, curv + 1, curw + 2, dic):
                return dic
            del dic[int(V[idx][curv])]
        if curw + 3 <= len(W[idx]) and check_and_set(V[idx][curv], "".join(W[idx][curw: curw + 3]), dic):
            if solve(idx, curv + 1, curw + 3, dic):
                return dic
            del dic[int(V[idx][curv])]
    else:
        if len(W[idx]) - curw > 3:
            return False
        else:
            if not check_and_set(V[idx][curv], "".join(W[idx][curw:]), dic):
                return False
            else:
                if solve(idx + 1, 0, 0, dic):
                    return dic
            del dic[int(V[idx][curv])]
    return False


dic = {}

if solve(0, 0, 0, dic):
    for i in range(1, K + 1):
        print(dic[i])
