a, b = map(str, input().split())

if a == b:
    print("=")
else:
    print("<" if a < b else ">")

