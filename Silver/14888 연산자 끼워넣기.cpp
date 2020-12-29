#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include<climits>
using namespace std;

int n, temp;
vector<int> arr;
vector<int> oper;

int maxans = INT_MIN;
int minans = INT_MAX;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		arr.push_back(temp);
	}

	for (int i = 0; i < 4; i++) {
		cin >> temp;
		for (int j = 0; j < temp; j++) {
			oper.push_back(i);
		}
		
	}

	do {
		int sum = arr[0];
		for (int i = 1; i < arr.size(); i++) {
			switch (oper[i-1])
			{
			case 0:
				sum += arr[i];
				break;
			case 1:
				sum -= arr[i];
				break;
			case 2:
				sum *= arr[i];
				break;
			case 3:
				sum /= arr[i];
				break;
			default:
				break;
			}

			
		}

		maxans = max(maxans, sum);
		minans = min(minans, sum);

	} while (next_permutation(oper.begin(), oper.end()));
	
	cout << maxans << "\n" << minans;

}

