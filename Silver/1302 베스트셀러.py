import sys
from collections import deque

n = int(sys.stdin.readline())
dict = {}
for i in range(0, n):
    book = sys.stdin.readline().rstrip()
    if not dict.get(book):
        dict[book] = 1
    else:
        dict[book] += 1

lists = list(zip(dict.keys(),dict.values()))
lists = sorted(lists, key=lambda x:(-x[1], x[0]))
print(lists[0][0])
