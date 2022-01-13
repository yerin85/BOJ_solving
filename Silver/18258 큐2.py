import sys
from collections import deque

n = int(sys.stdin.readline())
q = deque() # deque 생성 필요!!

for _ in range(n):
    cmd = sys.stdin.readline().rstrip().rsplit()

    if cmd[0] == "push":
        q.append(cmd[1])
    elif cmd[0] == "pop":
        if not q:
            print("-1")
        else:
            print(q[0])
            q.popleft()
    elif cmd[0] == "size":
        print(len(q))
    elif cmd[0] == "empty":
        if not q:
            print("1")
        else:
            print("0")
    elif cmd[0] == "front":
        if not q:
            print("-1")
        else:
            print(q[0])
    else:
        if not q:
            print("-1")
        else:
            print(q[-1])
