#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include<climits>
#include <deque>
using namespace std;

int n, m;
deque<int> q;
int arr[51];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	int cnt = 0;

	for (int i = 1; i <= n; i++) q.push_back(i);
	
	for (int i = 0; i < m; i++) cin >> arr[i];

	for (int i = 0; i < m; i++) {
		int left = -1;
		int right = -1;

		if (arr[i] != q.front()) {
			for (int j = 0; j <= q.size() / 2; j++) {
				if (arr[i] == q.at(j)) {
					left = j;
					break;
				}
			}

			for (int j = q.size() / 2; j < q.size(); j++) {
				if (arr[i] == q.at(j)) {
					right = j;
					break;
				}
			}

			if (right == -1) {
				cnt += left;

				while (left--) {
					int temp = q.front();
					q.pop_front();
					q.push_back(temp);
				}
			}
			else if (left == -1) {
				int count = q.size() - right;
				cnt += count;

				while (count--) {
					int temp = q.back();
					q.pop_back();
					q.push_front(temp);
				}

			}
			else {
				int count = q.size() - right;

				if (left < count) {
					cnt += left;

					while (left--) {
						int temp = q.front();
						q.pop_front();
						q.push_back(temp);
					}
				}
				else {
					cnt += count;

					while (count--) {
						int temp = q.back();
						q.pop_back();
						q.push_front(temp);
					}
				}
			}

		}

		q.pop_front();


	}
	cout << cnt;
}
