import sys

s = sys.stdin.readline().rstrip()
lists = [0] * 26

for i in range(len(s)):
    lists[ord(s[i])-97] += 1 

print(*lists)
