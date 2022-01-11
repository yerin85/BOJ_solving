import sys

k = int(sys.stdin.readline())

for i in range(k):
    lists = list(map(int, sys.stdin.readline().rsplit()))

    del lists[0] # 첫번째수는 제거
    print("Class", i+1)

    lists.sort() # 내림차순으로 정렬
    lg = 0
    for i in range(0, len(lists)-1):
        if lists[i+1] - lists[i] > lg:
            lg = lists[i+1] - lists[i]

    print(f'Max {max(lists)}, Min {min(lists)}, Largest gap {lg}')

# 파이썬 list index
# 첫번째 list[0] / 마지막 list[-1]

# list 인덱스를 같이 얻으려면
# for i, value in enumerate(list)
