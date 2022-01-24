import sys

n = int(sys.stdin.readline())
lists = []

for i in range(0, n):
    x, y = map(int, sys.stdin.readline().rsplit())
    lists.append([x, y])

lists.sort(key = lambda x:(x[1], x[0]))

for x, y in lists:
    print(x, y)
