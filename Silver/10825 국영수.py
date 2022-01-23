import sys

n = int(sys.stdin.readline())
lists = []

for _ in range(0, n):
    name, ko, en, math = sys.stdin.readline().rstrip().rsplit()
    ko = int(ko)
    en = int(en)
    math = int(math)
    lists.append([name, ko, en, math])

lists.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for list in lists:
    print(list[0])
