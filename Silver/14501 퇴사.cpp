#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <functional>
using namespace std;

int n, a, b;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int time[16];
	int pay[16];
	int D_pay[16];
	for (int i = 0; i < 16; i++) {
		time[i] = 0;
		pay[i] = 0;
		D_pay[i] = 0;
	}

	cin >> n;
	for (int t = 1; t <= n; t++) {
		cin >> time[t] >> pay[t];
	}

	int ans = 0;

	for (int i = n; i > 0; i--) {
		if (i + time[i] - 1 <= n) {
			
				int maxx = 0;
                //i+time[i]일 이후 최대값 찾기
				for (int j = i + time[i]; j <= n; j++) {
					if (maxx < D_pay[j]) maxx = D_pay[j];
				}
                //최대값+상담성공시 수당
				D_pay[i] = maxx+pay[i];
			
		}
		ans = max(ans, D_pay[i]);
	}
	
	cout <<ans;

}
