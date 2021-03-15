H, W = map(int, input().split())

S = [input() for _ in range(H)]

sh, sw = -1, -1
for h in range(H):
    for w in range(W):
        if sh < 0 and S[h][w] == "#":
            sh, sw = h, w

ch, cw, dir = sh, sw, 0
dh, dw = [0, 1, 0, -1], [1, 0, -1, 0]
nh, nw = [-1, 1, 1, -1], [1, 1, -1, -1]
cnt = 0
for _ in range(100):
    if (dir & 1) == 0:
        if S[ch + dh[dir]][cw + dw[dir]] == "#":
            if S[ch + nh[dir]][cw + nw[dir]] == "#":
                cnt += 1
                ch += nh[dir]
                cw += nw[dir]
                dir = (dir + 3) % 4
            else:
                ch += dh[dir]
                cw += dw[dir]
        else:
            cnt += 1
            dir = (dir + 1) % 4
    else:
        if S[ch + dh[dir]][cw + dw[dir]] == "#":
            if S[ch + nh[dir]][cw + nw[dir]] == "#":
                cnt += 1
                ch += nh[dir]
                cw += nw[dir]
                dir = (dir + 3) % 4
            else:
                ch += dh[dir]
                cw += dw[dir]
        else:
            cnt += 1
            dir = (dir + 1) % 4

    if ch == sh and cw == sw and dir == 0:
        break
#    print(ch, cw, dir, cnt)

print(cnt)

"""
5 5
.....
..##.
.##..
.#...
.....
"""