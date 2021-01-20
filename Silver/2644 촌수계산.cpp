#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m, x, y, a, b;
int people[101];
vector<int> v[101];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> a >> b;
	for (int i = 1; i <= n; i++) people[i] = -1;
	cin >> m;

	while (m--) {
		cin >> x >> y;
		people[y] = x;
	}

	int cnt = 0;
	bool flag = false;
	bool cnt_check = false;

	while (true) {
		if (flag && b == -1) break;
		
		if (!flag) {
			v[0].push_back(a);
			if (people[a] == -1) flag = true;
			else a = people[a];		
		}
		else {
			v[1].push_back(b);
			b = people[b];
		}
	}
	
	//cout << endl;
	//for (int i = 0; i < 2; i++) {
	//	for (int j : v[i]) cout << j << " ";
	//	cout << endl;
	//}


	int a_size = v[0].size()-1;
	int b_size = v[1].size()-1;

	if (v[0][a_size] == v[1][b_size]) {
		if (a_size == b_size) {
			int last = a_size;
			while (v[0][last] == v[1][last]) {
				v[0].pop_back();
				v[1].pop_back();
				last--;
			}
		}
		else {
			int last1 = a_size;
			int last2 = b_size;
		
			//이부분수정
			while (v[0][last1] == v[1][last2]) {
				v[0].pop_back();
				v[1].pop_back();
				last1--;
				last2--;

				if (last1 < 0 || last2 < 0) break;
			}
		}

		//cout << endl;
		//for (int i = 0; i < 2; i++) {
		//	for (int j : v[i]) cout << j << " ";
		//	cout << endl;
		//}

		if (v[0].empty()) cout << v[1].size();
		else if (v[1].empty()) cout << v[0].size();
		else cout << v[0].size() + v[1].size();
	}
	else cout << -1;

	
	
}
