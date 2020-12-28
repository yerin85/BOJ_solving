#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
string s;
vector<int> v;

void func(int num) {
	if (v.size() == m) {
		for (int i : v) cout << i << " ";
		cout << "\n";

		return;
	}

	for (int i = num; i <= n; i++) {
		v.push_back(i);
		func(i);
		v.pop_back();
	}

	return;

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	func(1);
}

