import sys

lists = []

for i in range(8):
    lists.append([i+1, int(sys.stdin.readline().rstrip())]) # 인덱스, 점수 삽입

lists.sort(key= lambda x: x[1], reverse=True) # 점수를 기준으로 정렬

number = []
sum = 0

for i in range(5):
    sum += lists[i][1] # 1~5등 점수 저장
    number.append(lists[i][0]) # 1~5등 인덱스 저장

print(sum)
print(*sorted(number)) # 인덱스 정렬해서 출력
