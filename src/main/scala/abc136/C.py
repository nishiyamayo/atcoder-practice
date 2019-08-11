n = int(input())
a = list(map(int, input().split()))
ok = True
a[0] -= 1
for i in range(1, n):
    if a[i - 1] < a[i]:
        a[i] -= 1
    if a[i - 1] > a[i]:
        ok = False

print("Yes" if ok else "No")
