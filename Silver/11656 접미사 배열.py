import sys

s = sys.stdin.readline().rstrip()
lists = []

for i in range(0, len(s)):
    lists.append(s[i:])
lists.sort()
print(*lists, sep='\n')
