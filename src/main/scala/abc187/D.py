
N = int(input())

AS = 0
BS = 0
L = []
for i in range(N):
    A, B = map(int, input().split())
    L.append((A, B))
    AS += A

L.sort(key=lambda x: x[1] + 2 * x[0], reverse=True)
# print(L)

cnt = 0
for l in L:
    if BS > AS:
        break

    BS += l[0] + l[1]
    AS -= l[0]
    cnt += 1
    # print(AS, BS)

print(cnt)
