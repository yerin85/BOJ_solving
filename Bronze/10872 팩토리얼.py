import sys

def fact(num, i):
    if i <= 1:
        return num
    return fact(num * i, i-1)


n = int(sys.stdin.readline())
print(fact(1, n))
