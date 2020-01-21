N, K = map(int, input().split())
R, S, P = map(int, input().split())

T = input()
used = [False] * N

score = 0
for i, c in enumerate(T):
    if i >= K:
        if c == T[i - K] and used[i - K]:
            pass
        else:
            if c == 'r':
                score += P
            elif c == 'p':
                score += S
            else:
                score += R
            used[i] = True
    else:
        if c == 'r':
            score += P
        elif c == 'p':
            score += S
        else:
            score += R
        used[i] = True

print(score)