N = int(input())
ats = [list(map(int, input().split())) for _ in range(N)]
ats = sorted(ats)

l = ats[-1][0]
mw = 0

for at in ats:
    a, t = at[0], at[1]
    mw = max(mw, t - (2 * l - a))

print(mw + 2 * l)