import sys

n = int(sys.stdin.readline().rstrip())
stack = []

for _ in range(n):
    cmd = sys.stdin.readline().rstrip().rsplit() # 개행문자 제거 후 공백으로 나누기

    if cmd[0] == "push": # list뒤에 삽입
        stack.append(cmd[1])
    elif cmd[0] == "pop": # 마지막 인덱스를 찾아서 제거
        top = len(stack) - 1
        if top == -1:
            print(-1)
        else:
            print(stack[top])
            stack.pop()
    elif cmd[0] == "size": # 길이 출력
        print(len(stack))
    elif cmd[0] == "empty": 
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    else:
        if len(stack) == 0:
            print(-1)
        else:
            top = len(stack) - 1
            print(stack[top])
