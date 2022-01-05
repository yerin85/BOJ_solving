import sys

n = int(sys.stdin.readline())
sum = 0

for _ in range(n):
    str = sys.stdin.readline().rstrip()
    list = [-1] * 26
    check = True

    for i in range(len(str)):
        if list[ord(str[i])-97] == -1:
            list[ord(str[i])-97] = i
        else:
            if i - list[ord(str[i])-97] > 1: # 이전에 나왔을 때 이전 위치와 현재 위치 차이가 1이상 날 경우 체크
                check = False
                break
            else: # 이어서 나오는 경우라면 값 변경
                list[ord(str[i]) - 97] = i

    if check:
        sum += 1

print(sum)
