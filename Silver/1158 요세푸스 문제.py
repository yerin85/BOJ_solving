import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
dq = deque()
output = []

for i in range(1, n+1):
    dq.append(i)

while dq:
    dq.rotate(-k) # k만큼 rotate
    output.append(dq[-1])
    dq.pop()

print("<", end='')
print(*output, sep=", ", end='')
print(">")
