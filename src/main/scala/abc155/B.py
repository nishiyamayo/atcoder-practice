N = int(input())
A = list(map(int, input().split()))

def f():
    for a in A:
        if a % 2 == 0 and (a % 3 != 0 and a % 5 != 0):
            print("DENIED")
            return
    print("APPROVED")

f()