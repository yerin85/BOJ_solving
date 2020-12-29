#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m, k, s, a, b;
vector<int> adj[300001];
int d[300001];
priority_queue<int> pq;

int main() {
	cin >> n >> m >> k >> s;

	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		adj[a].push_back(b);
	}

	for (int i = 1; i <= n; i++) d[i] = 987654321;

	d[s] = 0;
	pq.push(s);

	while (!pq.empty()) {
		int temp = pq.top();
		pq.pop();

		for (int next : adj[temp]) {
			if (d[next] > d[temp] + 1) {
				d[next] = d[temp] + 1; //따로 비용이 존재하지 않고 거리 이동이기 때문에 +1
				pq.push(next);
			}
		}
	}

	bool flag = false;
	for (int i = 1; i <= n; i++) {
		if (d[i] == k) {
			cout << i << "\n";
			flag = true;
		}
	}

	if (!flag) cout << -1;
}
