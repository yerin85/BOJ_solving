import sys
from collections import deque

lists = []
for i in range(1, 8):
    num = int(sys.stdin.readline().rstrip())
    if num % 2 == 1:
        lists.append(num)

if not lists:
    print("-1")
else:
    print(sum(lists))
    lists.sort()
    print(lists[0])
