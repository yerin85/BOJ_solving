#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int n, ans;
string s;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 2; i <= n; i++) {
		if (i % 5 == 0) ans++;
		if (i % 25 == 0) ans++;
		if (i % 125 == 0) ans++;
	}
	cout << ans;
}

