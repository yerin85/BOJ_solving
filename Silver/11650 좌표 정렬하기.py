import sys

n = int(sys.stdin.readline())
lists = []
for _ in range(n):
    xy = list(map(int, sys.stdin.readline().rsplit()))
    lists.append(xy) # 리스트 형태로 삽입

lists.sort(key=lambda x:(x[0], x[1])) # x증가, y증가하는 순으로 정렬

for x, y in lists:
    print(x, y)
