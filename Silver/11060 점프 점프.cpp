#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int n, t;
int arr[1001];
int D[1001][1001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) cin >> arr[i];
	for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
		D[i][j] = 987654321;
	}

	D[0][0] = 0;

	for (int i = 0; i < n; i++) {
		for (int j = i; j <n; j++) {
			if (i == 0) {
				if (j == 0) continue;
				else if (j <= i + arr[i]) D[i][j] = D[i][i] + 1;
			}
			else {
				if (i == j) D[i][j] = D[i - 1][j];
				else if (j <= i + arr[i]) D[i][j] = min(D[i][i] + 1, D[i - 1][j]);
				else if (D[i - 1][j] != 987654321) D[i][j] = D[i - 1][j];
			}
		}
	}

	if (D[n - 1][n - 1] == 987654321) cout << -1;
	else cout << D[n - 1][n - 1];
}
