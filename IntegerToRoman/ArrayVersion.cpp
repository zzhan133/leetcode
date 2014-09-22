#include	<string>
#include	<iostream>
using namespace std;

class Solution {
public:
    string intToRoman(int num) {  //num >= 1 and num<=3999
       //	static char convert_table[] = {'I','V','X','L','C','D','M'}; 
	static string digit[10] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
	static string ten[10] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	static string hundred[10] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
	static string thousand[4] = {"","M","MM","MMM"};
       
       string results;
       //1.determine the number for the thousand
       int thousand_num = num/1000;
       num = num%1000;
       int hundred_num = num/100;
       num = num%100;
       int ten_num = num/10;
       num = num%10;
       results.append(thousand[thousand_num]);
              results.append(hundred[hundred_num]);
	             results.append(ten[ten_num]);
		            results.append(digit[num]);
	
	return results;	
	
    }
};

int main()
{
	int num = 0;
	Solution instance;
	while(1)
	{
		cin>>num;
		if(num < 1 || num > 3999)
			break;
		cout << instance.intToRoman(num) << endl;
	}
	
	
	return 0;
}


