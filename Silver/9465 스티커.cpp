#include <iostream>
#include <algorithm>
using namespace std;

int t, n;
int arr[2][100001];
int D[2][100001];
int main() {
	cin >> t;
	while (t--) {


		cin >> n;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) cin >> arr[i][j];
		}

		D[0][0] = arr[0][0];
		D[1][0] = arr[1][0];

		if (n > 1) {
			D[0][1] = arr[1][0] + arr[0][1];
			D[1][1] = arr[0][0] + arr[1][1];
		}


		int idx = 2;
		while (idx < n) {
			D[0][idx] = max(max(D[1][idx - 2] + arr[0][idx], D[1][idx - 1] + arr[0][idx]), D[0][idx - 2] + arr[0][idx]);
			D[1][idx] = max(max(D[0][idx - 2] + arr[1][idx], D[0][idx - 1] + arr[1][idx]), D[1][idx - 2] + arr[1][idx]);
			idx++;
		}

		int ans = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				//cout << D[i][j] << " ";
				ans = max(D[i][j], ans);
				D[i][j] = 0;
			}//cout << endl;
		}

		cout << ans << "\n";
	}


}
