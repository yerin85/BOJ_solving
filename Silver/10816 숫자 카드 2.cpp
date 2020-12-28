#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
	int n, m, temp;
	vector<int> have;
	vector<int> find;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		have.push_back(temp);
	}
	sort(have.begin(), have.end());

	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> temp;
		find.push_back(temp);
	}

	for (int i = 0; i < m; i++) {
		auto up = upper_bound(have.begin(), have.end(), find[i]);
		auto lo = lower_bound(have.begin(), have.end(), find[i]);

		cout << up - lo << " ";
	}



}
