#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int n, temp;
vector<int> arr;
int D[1001][1001];


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		arr.push_back(temp);
	}

	D[0][0] = arr[0];
	int answer = 0;

	for (int i = 0; i < arr.size(); i++) {
		if (i != 0) D[i][i] = D[i-1][i];
		if (answer < D[i][i]) answer = D[i][i];

		
		for (int j = i + 1; j < arr.size(); j++) {
			if (arr[i] < arr[j]) {
				if (i == 0) D[i][j] = D[i][i] + arr[j];
				else D[i][j] = max(D[i][i] + arr[j], D[i - 1][j]);
			}
			else {
				if (i == 0) D[i][j] = arr[j];
				else D[i][j] = D[i - 1][j];
			}
			if (answer < D[i][j]) answer = D[i][j];
		}

	}
	cout << answer;
}

