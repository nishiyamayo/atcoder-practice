S, T = input().split()
s, t = map(int, input().split())
U = input()

if S == U:
    print(s - 1, t)
else:
    print(s, t - 1)