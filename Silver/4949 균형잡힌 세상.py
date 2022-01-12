
while True:
    str = input()
    stack = []
    flag = True

    if str == '.': # 종료 조건
        break

    for word in str:
        if word in '([':
            stack.append(word)
        elif word in ')]':
            if stack:
                if (stack[-1] == "(" and word == ")") or (stack[-1] == "[" and word == "]"):
                    stack.pop()
                else:
                    flag = False
                    break
            else: # 스택이 비어있으면 false
                flag = False
                break

    if flag:
        if not stack:
            print("yes")
        else:
            print("no")
    else:
        print("no")
        
        
"""
반례 [()][. 
flag로만 체크하고 stack에 남아있을 때 체크를 안해서 오답 
"""
