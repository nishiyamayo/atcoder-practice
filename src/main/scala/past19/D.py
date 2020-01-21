N = int(input())

flg = [False] * N

ch = -1

for _ in range(N):
    A = int(input()) - 1
    if flg[A]:
        ch = A + 1
    flg[A] = True

end = False
for i in range(N):
    if not flg[i]:
        print(ch, i + 1)
        end = True
        break

if not end:
    print("Correct")