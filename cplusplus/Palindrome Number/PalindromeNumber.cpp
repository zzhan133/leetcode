#include	<iostream>
using namespace std;

class Solution {
public:
	int valueOfNumber(int x, int n)  //The value of the nth digit of the value from right to left
    {
        int base = 1;
        while(n!= 1)
        {
            base = base*10;
            n--;
        }
        return (x/base)%10;
    }
    bool isPalindrome(int x) {
        if(x > -10 && x < 10)
            return true;
        //If x is negative, then consider its positive version
        if(x < 0)
            return isPalindrome(0-x);
        //When x is positive
        int digit_num = 0;
		int backup = x;
        while(x != 0)
        {
            x = x/10;
            digit_num++;
        }
        //Find the middle number
        //1.If digit_num is odd
		x = backup;
        if(digit_num%2 == 1){
            int mid = digit_num/2 + 1;
            int i = 1;
            while(i!=mid)
            {
                int left = valueOfNumber(x,mid-i);
                int right = valueOfNumber(x, mid+i);
                if(left != right)
                    return false;
                i++;
            }
            return true;
        }
        //2.If digit_num is even
        else{
            int mid = digit_num/2;
            int i = 0;
            while(i!=mid)
            {
                int left = valueOfNumber(x,mid-i);
                int right = valueOfNumber(x, mid+(i+1));
                if(left != right)
                    return false;
                i++;
            }
            return true;
        }
        
        
    }
};

int main()
{
	int num = 0;
	Solution instance;
	while(1)
	{
		cin>>num;
		if(num == 0)
			break;
		cout << instance.isPalindrome(num) << endl;
	}
	
	
	return 0;
}
 
