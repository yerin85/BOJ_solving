import sys

n = int(sys.stdin.readline())
users = []

for _ in range(n):
    age, name = sys.stdin.readline().rstrip().rsplit()
    users.append([int(age), name]) # 2차원 리스트로 저장

users.sort(key=lambda x: x[0]) # 0번 인덱스를 기준으로 정렬

for i, j in users:
    print(i, j)

"""
1. 나이를 형변환하지 않아서 str로 정렬을 함
    반례
        input:
            3
            1 a
            15 b
            9 c
        output:
            1 a
            15 b
            9 c
        answer:
            1 a
            9 c
            15 b   
"""
