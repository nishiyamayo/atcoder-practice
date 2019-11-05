n = int(input())
s = input()
ans = 0
for c in s:
    if "aiueo".__contains__(c):
        ans += 1

print(ans)