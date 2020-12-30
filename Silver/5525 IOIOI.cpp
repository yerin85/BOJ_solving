#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include<climits>
#include <deque>
using namespace std;

int n, m;
string s;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> s;
	int p_cnt = 0;
	int ans = 0;

	for (int i = 0; i < s.length()-2;) {
		if (s[i] == 'I') {
			if (s[i + 1] == 'O' && s[i + 2] == 'I') {
				p_cnt++;
				i += 2;

				if (p_cnt == n) {
					p_cnt--;
					ans++;
				}
			}
			else {
				p_cnt = 0;
				i++;
			}
		}
		else i++;
	}

	cout << ans;
}
