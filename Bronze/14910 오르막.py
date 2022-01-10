import sys

lists = list(map(int, sys.stdin.readline().rsplit()))

prev = lists[0] # 이전값과 비교
check = True

for i in range(1, len(lists)):
    if prev > lists[i]: # 이전값이 더 크다면 brak
        check = False
        break
    prev = lists[i]

if check:
    print("Good")
else:
    print("Bad")

