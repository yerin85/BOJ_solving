import sys

t = int(sys.stdin.readline())

for _ in range(t):
    lists = list(map(int, sys.stdin.readline().rstrip().rsplit())) # 정수 여러 개를 리스트에다 입력받음
    lists.sort()
    print(lists[-3]) # 오름차순 정렬이므로 뒤에서 3번째 수 출력
