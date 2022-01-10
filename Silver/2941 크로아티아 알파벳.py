import sys

alpha = sys.stdin.readline().rstrip()

alpha = alpha.replace('c=', '1')
alpha = alpha.replace('c-', '2')
alpha = alpha.replace('dz=', '3')
alpha = alpha.replace('d-', '4')
alpha = alpha.replace('lj', '5')
alpha = alpha.replace('nj', '6')
alpha = alpha.replace('s=', '7')
alpha = alpha.replace('z=', '8')

print(len(alpha))
