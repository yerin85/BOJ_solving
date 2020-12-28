#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<int> v;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 1; i <= n; i++) v.push_back(i);
	
	do {
		for (int i : v) {
			cout << i << " ";
		}cout << "\n";
	} while (next_permutation(v.begin(), v.end()));
}

