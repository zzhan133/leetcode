#include <string>
#include <climits>
class Solution {
public:
	bool val(const char *str, int iBegin, double &sum){
		if (iBegin == strlen(str)){
			return true;
		}
		char cTmp = str[iBegin];
		if (cTmp < 48 || cTmp > 57){
			return false;
		}
		sum = sum * 10 + (cTmp - 48);
		if (sum >= 2147483648){
			return true;
		}
		val(str, iBegin + 1, sum);
		return true;
	}
	int atoi(const char *str) {
		int n = strlen(str);
		int i = 0;
		while (i<n){
			if (str[i] == ' ')
				i++;
			else
				break;
		}
		if (i == n){
			return 0;
		}
		bool flag = true;
		if (str[i] == '-'){
			flag = false;
			i++;
		}
		else if (str[i] == '+'){
			i++;
		}
		double sum = 0;
		val(str, i, sum);
		if (sum >= 2147483648){
			if (flag == false)
				return INT_MIN;
			else
				return INT_MAX;
		}
		if (flag == false){
			int tmp = 0 - (int)sum;
			return tmp;
		}
		return (int)sum;
	}
};