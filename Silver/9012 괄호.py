import sys

t = int(sys.stdin.readline())

for _ in range(t):
    str = sys.stdin.readline().rstrip()

    stack = []
    check = False

    for i in range(len(str)):
        if str[i] == "(": # 왼쪽 괄호가 들어온 경우 삽입
            stack.append(str[i])
        else: # 오른쪽 괄호가 들어온 경우 제거
            if len(stack) == 0:
                check = True
                break
            else:
                stack.pop()

    if len(stack) > 0: # 남아있는 왼쪽 괄호가 존재하는 경우 올바르지 않은 괄호 문자열
        check = True

    if check:
        print("NO")
    else:
        print("YES")
