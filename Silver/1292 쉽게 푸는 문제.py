import sys

a, b = map(int, sys.stdin.readline().rstrip().rsplit()) # map(int, list)

lists = [0, 1, ]
num = 2


while len(lists) < 1000: # 최대 인덱스가 1000
    for _ in range(0, num):
        lists.append(lists[len(lists)-1]+num) # num 수 만큼 전 값에 더함

    num+=1

print(lists[b]-lists[a-1]) # 끝(b)에서 시작(a)를 빼면 구간 사이 합
