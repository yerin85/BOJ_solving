#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, temp;
vector<int> v, ans;

void func(int idx) {
	if (ans.size() == m) {
		for (int i : ans) {
			cout << i << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = idx; i < n; i++) {
			ans.push_back(v[i]);
			func(i);
			ans.pop_back();

	}

	return;

}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		v.push_back(temp);
	}
	sort(v.begin(), v.end());

	func(0);
}

