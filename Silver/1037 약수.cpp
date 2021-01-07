#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
int test, n, x, temp;
int arr[51];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) cin >> arr[i];
	sort(arr, arr + n);
	cout << arr[0] * arr[n - 1];
}
