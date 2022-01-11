# :seedling:BOJ_solving:seedling:

> ##### 백준 문제를 풀고있습니다:octocat:
***


#### 진행 환경

OS : Window 10

IDE : Microsoft Visual Studio Community 2019 / Eclipse

Compiler : Visual C++ Compiler / Java Compiler 12

***


#### MEMO 📝

1. 변수 저장할 때 타입 주의(반드시 정수, 문자열 확인하기)

[참고1](https://github.com/yerin85/BOJ_solving/blob/8600a0b0975b583e181e17e4d3ea3b2ef16fa4ee/Silver/10814%20%EB%82%98%EC%9D%B4%EC%88%9C%20%EC%A0%95%EB%A0%AC.py "나이순정렬")
 
2. 마지막 변수 list[-1] 
3. for문에서 idx, value 같이 얻으려면 enumerate()
```python
for i, value in enumerate(lists):
 print(i, value)
```

4. 정렬
```python
list.sort() # 오름차순
list.sort(reverse = True) #내림차순 False는 오름차순
list.sort(key = len) # 길이순 정렬
list.sort(key = lambda x: x) # 오름차순
list.sort(key = lambda x: (len(x), x)) # 길이, 값 순으로 정렬
```
