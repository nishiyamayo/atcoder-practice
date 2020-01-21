import sys
sys.setrecursionlimit(10 ** 6)

class BNF:

    MOD = 1000000007


    def __init__(self, S):
        self.S = S + "="
        self.p = 0

    def next_char(self):
        nx = self.S[self.p]
        self.p += 1
        return nx

    def expr(self):
        R, P, S = self.term()
        c = self.next_char()
        # print("expr", R, P, S, c, self.p)
        while c == '+' or c == '-':
            NR, NP, NS = self.term()
            if c == '+':
                R, P, S = ((R * NS + S * NR + R * NR) % self.MOD, (P * NR + R * NP + P * NP) % self.MOD, (S * NP + P * NS + S * NS) % self.MOD)
            else:
                R, P, S = ((R * NP + P * NR + R * NR) % self.MOD, (P * NS + S * NP + P * NP) % self.MOD, (S * NR + R * NS + S * NS) % self.MOD)
            c = self.next_char()

        self.p -= 1

        return R, P, S

    def term(self):
        R, P, S = self.factor()
        c = self.next_char()
        # print("term", R, P, S, c, self.p)

        while c == '*':
            # print(c)
            NR, NP, NS = self.factor()
            R, P, S = ((P * NS + S * NP + R * NR) % self.MOD, (S * NR + R * NS + P * NP) % self.MOD, (R * NP + P * NR + S * NS) % self.MOD)
            c = self.next_char()

        self.p -= 1
        return R, P, S

    def factor(self):
        c = self.next_char()
        # print("factor", c, self.p)

        if c == '(':
            R, P, S = self.expr()
            self.p += 1
            return R, P, S
        elif c == 'R':
            return 1, 0, 0
        elif c == 'P':
            return 0, 1, 0
        elif c == 'S':
            return 0, 0, 1
        else: # c == '?'
            return 1, 1, 1

_ = int(input())
S = input()
A = input()

bnf = BNF(S)

R, P, S = bnf.expr()

if A == 'R':
    print(R)
elif A == 'P':
    print(P)
else:
    print(S)