#include <iostream>
#include <vector>
using namespace std;

int n, a, b;
vector<int> v[100001];
int arr[100001];

void dfs(int num, int root) {
	while (!v[num].empty()) {
		int temp = v[num].back();
		if (temp == root) v[num].pop_back();
		else {
			arr[temp] = num;
			v[num].pop_back();
			dfs(temp, num);
		}

	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	arr[1] = -1;
	cin >> n;
	for(int i=1;i<n;i++){
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	dfs(1, -1);
	for (int i = 2; i <= n; i++) cout << arr[i] << "\n";
}
