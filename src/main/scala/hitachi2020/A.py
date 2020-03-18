S = input()

L = len(S)

def print_ans():
    for i in range(L):
        if i % 2 == 0 and S[i] != 'h':
            print("No")
            return
        if i % 2 == 1 and S[i] != 'i':
            print("No")
            return

    print("Yes")

print_ans()