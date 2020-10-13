#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define inf 987654321

struct info {
	int node, cost;

	info(int n, int w) {
		node = n;
		cost = w;
	}

	bool operator < (const info a) const {
		return cost > a.cost;
	}
};



//그래프 다익스트라 할 때는 인접행렬이랑 다익스트라 값 저장 만들기
int n, m, s, e, w;
vector<info> adj[1001];
int D[1001];
queue<int> q;

int main() {
	
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> s >> e >> w;
		adj[s].push_back(info(e, w));
	}
	cin >> s >> e;

	for (int i = 1; i <= n; i++) D[i] = inf; // 초기화
	

	priority_queue <info> pq;
	D[s] = 0;
	pq.push(info(s, 0));

	while (!pq.empty()) {
		info i = pq.top();
		pq.pop();

		int node = i.node;
		int cost = i.cost;

		for (info next : adj[node]) {
			int next1 = next.node;
			if (D[next.node] > D[node] + next.cost) {
				D[next.node] = D[node] + next.cost;
				pq.push(info(next.node, D[next.node]));
			}
		}
	}

	cout << D[e];

	return 0;
}
