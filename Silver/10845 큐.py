import sys

n = int(sys.stdin.readline())
queue = []

for _ in range(n):
    cmd = sys.stdin.readline().rstrip().rsplit()

    if cmd[0] == "push":
        queue.append(cmd[1])
    elif cmd[0] == "pop":
        if not queue:
            print("-1")
        else:
            print(queue[0])
            del queue[0] # front 제거
    elif cmd[0] == "size":
        print(len(queue))
    elif cmd[0] == "empty":
        if not queue:
            print("1")
        else:
            print("0")
    elif cmd[0] == "front":
        if not queue:
            print("-1")
        else:
            print(queue[0])
    else:
        if not queue:
            print("-1")
        else:
            print(queue[-1])
