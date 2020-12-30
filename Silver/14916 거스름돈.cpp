#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include<climits>
using namespace std;

int n;
int D[100001];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	int cnt = 0;

	for (int i = 0; i <= n; i++) D[i] = 987654321;

	for (int i = 2; i <= n; i++) {
		if (i % 5 == 0) D[i] = i / 5;
		else {
			//5의 배수가 아닌 애들
			if (i % 2 == 0 && D[i] == 987654321) D[i] = i / 2;
			
			if (i > 5) {
				if (D[i - 5] != 987654321) D[i] = min(D[i], D[5] + D[i - 5]);

			}
		}
	}

	if (D[n] == 987654321) cout << -1;
	else cout << D[n];
}
