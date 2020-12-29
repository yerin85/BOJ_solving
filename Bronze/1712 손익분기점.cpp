#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include<climits>
using namespace std;

long long a, b, c;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b >> c;
	int ans = 0;

	if (c - b <= 0) cout << -1;
	else {
		ans = a / (c - b);
		cout << ans + 1;
	}
	

}
