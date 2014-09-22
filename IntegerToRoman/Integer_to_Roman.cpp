class Solution {
public:
    string intToRoman(int num) {  //num >= 1 and num<=3999
       static char convert_table[] = {'I','V','X','L','C','D','M'}; 
       string results;
       //1.determine the number for the thousand
       int thousand_num = num/1000;
       num = num%1000;
	       while(thousand_num != 0)
	       {
		       results.push_back('M');
		       thousand_num--;
	       }
	//2. determinc the number for the hundred
	int hundred_num = num/100;
	int num = num%100;
	if(hundred_num == 9)
	{
		results.push_back('C');
		results.push_back('M');
	}
	else if(hundred_num > 4)
	{
		results.push_back('D');
		while(hundred_num - 5 != 0)
		{
			results.push_back('C');
			hundred_num--;
		}
	}
	else if(hundred_num == 4)
	{
		results.push_back('C');
		results.push_back('D');
	}
	else
	{
		while(hundred_num != 0)
		{
			results.push_back('C');
			hundred_num--;
		}
	}

	//3. determine the number of the ten number
	int ten_num = num/100;
	int num = num%100;
	if(ten_num == 9)
	{
		results.push_back('X');
		results.push_back('C');
	}
	else if(ten_num > 4)
	{
		results.push_back('L');
		while(ten_num - 5 != 0)
		{
			results.push_back('X');
			ten_num--;
		}
	}
	else if(ten_num == 4)
	{
		results.push_back('X');
		results.push_back('L');
	}
	else
	{
		while(ten_num != 0)
		{
			results.push_back('X');
			ten_num--;
		}
	}


	int digit_num = num/100;
	if(digit_num == 9)
	{
		results.push_back('I');
		results.push_back('X');
	}
	else if(digit_num > 4)
	{
		results.push_back('V');
		while(digit_num - 5 != 0)
		{
			results.push_back('I');
			digit_num--;
		}
	}
	else if(digit_num == 4)
	{
		results.push_back('I');
		results.push_back('V');
	}
	else
	{
		while(digit_num != 0)
		{
			results.push_back('I');
			digit_num--;
		}
	}
	
	return results;	
	
    }
};

