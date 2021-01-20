N = int(input())
A = list(map(int, input().split()))
A = list(enumerate(A))

while len(A) != 2:
    temp = []
    for i in range(len(A) // 2):
        if A[2 * i][1] > A[2 * i + 1][1]:
            temp.append(A[2 * i])
        else:
            temp.append(A[2 * i + 1])

    A = temp

if A[0][1] > A[1][1]:
    print(A[1][0] + 1)
else:
    print(A[0][0] + 1)
