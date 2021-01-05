#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <functional>
#include <queue>
using namespace std;

int n;
int ans = 0;
int check[16];
bool isOK(int cnt) {
	for (int i = 0; i < cnt; i++) {
		if (check[i] == check[cnt] || (cnt - i) == abs(check[i] - check[cnt])) return false;
	}

	return true;
}
void comb(int cnt) {
	if (cnt == n) {
		ans++;
		return;
	}
	else {
		for (int i = 0; i < n; i++) {
			check[cnt] = i;

			if (isOK(cnt)) {
				comb(cnt + 1);
			}
			
		}
	}
}





int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	//n*n 체스판위에 퀸 n 개를 서로 공격 못하게
	comb(0);
	cout << ans;

}
