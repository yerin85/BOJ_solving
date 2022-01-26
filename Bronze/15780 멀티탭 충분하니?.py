import sys

n, k = map(int, sys.stdin.readline().split())
# n 학생, k 멀티탭 수
a = list(map(int, sys.stdin.readline().split()))
# 멀티탭 구의 수
possible = 0
check = False
for i in a:
    if i%2 == 1:
        possible = i//2 +1
    else:
        possible = i//2

    n -= possible

    if n <= 0:
        check = True
        break

if check:
    print("YES")
else:
    print("NO")
