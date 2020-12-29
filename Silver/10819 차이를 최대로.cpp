#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include<climits>
using namespace std;

int n, temp, ans;
vector<int> arr, sear;



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		arr.push_back(temp);
	}

	sort(arr.begin(), arr.end());

	do {
		int sum = 0;
		for (int i = 0; i < arr.size()-1; i++) {
			sum += abs(arr[i] - arr[i + 1]);
		}
		
		ans = max(ans, sum);
	} while (next_permutation(arr.begin(), arr.end()));
	cout << ans;




}

