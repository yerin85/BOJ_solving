#include <iostream>
#include <algorithm>
using namespace std;

int t, n;
int arr[1001];
int D[1001];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) cin >> arr[i];

	for (int i = 0; i < n; i++) {
		D[i] = 1;
		for (int j = 0; j < n; j++) {
			if (arr[i] < arr[j] && D[i] < D[j]+ 1) D[i] = D[j] + 1;
		}
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		ans = max(ans, D[i]);
	}

	cout << ans;
}
