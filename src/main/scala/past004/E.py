import itertools

N = int(input())
S = input()

def solve(N, S):
    for l in itertools.permutations(S, N):
        r = reversed(l)
        r = "".join(r)
        l = "".join(l)
        if S == l or S == r:
            continue
        return "".join(l)
    return "None"

print(solve(N, S))
