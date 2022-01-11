import sys

k = int(sys.stdin.readline())
stack = []

# 최근 수를 지우기때문에 stack 사용
for _ in range(k):
    num = int(sys.stdin.readline())

    if num == 0:
        stack.pop()
    else:
        stack.append(num)

sum = 0
for n in stack:
    sum += n

print(sum)
