import sys

n = int(sys.stdin.readline())
words = []

for _ in range(n):
    word = sys.stdin.readline().rstrip()
    if word not in words: # words 리스트에 word가 존재하지 않는다면 삽입
        words.append(word)

#words.sort(key = len) # 문자열 길이로 정렬
words.sort(key=lambda x: (len(x), x)) # 여러 개를 정렬 기준으로 할 때는 괄호로 묶기
print(*words, sep='\n')
