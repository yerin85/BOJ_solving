#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <functional>
#include <queue>
using namespace std;

int n, m, a, b, k, temp;
int map[101][101];
bool check[101][101];

int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, -1, 0 , 1 };

void bfs(int x, int y) {
	queue<int> X;
	queue<int> Y;
	check[x][y] = true;
	temp = 1;

	for (int i = 0; i < 4; i++) {
		int nextX = x + dx[i];
		int nextY = y + dy[i];

		if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && map[nextX][nextY] == 1) {
			check[nextX][nextY] = true;
			temp++;
			X.push(nextX);
			Y.push(nextY);
		}
	}

	while (!X.empty()) {
		int x = X.front();
		int y = Y.front();
		X.pop();
		Y.pop();

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && map[nextX][nextY] == 1 && check[nextX][nextY] == false) {
				check[nextX][nextY] = true;
				temp++;
				X.push(nextX);
				Y.push(nextY);

			}
		}

	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> k;
	string s;
	for (int i = 0; i < k; i++) {
		cin >> a >> b;
		map[a - 1][b - 1] = 1;
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 1 && check[i][j] == 0) {
				bfs(i, j);
				ans = max(temp, ans);
			}
		}
	}


	cout << ans;

}
