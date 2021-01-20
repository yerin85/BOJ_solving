#include <iostream>
#include <deque>
#include <algorithm>
#include <queue>
#include <map>
using namespace std;

int n, cnt, a;
queue<int> q; //초반에 담는 곳
deque<pair<int,int>> picture;//현재 사진첩 (번호, 들어간 인덱스)
map<int, int> student; // (번호, 횟수)

bool comp(const pair<int, int>& a, const pair<int, int> &b){
	if (student[a.first] < student[b.first]) return true;
	else if (student[a.first] == student[b.first]) {
		return a.second < b.second;
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> cnt;
	for (int i = 0; i < cnt; i++) {
		cin >> a;
		q.push(a);
	}

	int cnt = 1;
	while (!q.empty()) {
		int num = q.front();
		bool flag = false;

		for (int i = 0; i < picture.size();i++) {
			if (picture[i].first == num) flag = true;
		}

		if (flag) student[num]++;
		else { //해당 번호가 사진첩에 없다면 
			if (picture.size() < n) { //그냥 들어가도 괜찮음
				picture.push_back(make_pair(num, cnt));
				student[num]++;
			}
			else {
				//제일 추천횟수가 적고, 같다면 오래된 것을 없애야함 
				sort(picture.begin(), picture.end(), comp);
				student[picture.front().first] = 0;
				picture.pop_front();
				picture.push_back(make_pair(num, cnt));
				student[num]++;
				
			}

		}

		cnt++;

		q.pop();
	}

	vector<int> ans;
	while (!picture.empty()) {
		ans.push_back(picture.front().first);
		picture.pop_front();
	}

	sort(ans.begin(), ans.end());
	for (int i : ans) {
		cout << i << " ";
	}

}
