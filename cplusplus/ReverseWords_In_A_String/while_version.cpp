#include	<string>
#include	<iostream>

using namespace std;

class Solution {
public:
	void reverseWords(string &s) {
		//This problem is just like quicksort
		//use two index to represent the space
		//This is used to store the reversed string
		if (s.size() == 0)
			return;
		int index = s.size();
		while (s[--index] == ' '&& index > 0); //length is the first position that is not ' '
		if (index == 0)
		{
			if (s[0] == ' ')
			{
				s = "";
				return;
			};
			string tmp(s,0,1);
			s = tmp;
			return;
		}
		//deal with leading
		int pre_index = -1;
		while (s[++pre_index] == ' ');//pre_index is not ' '
		string reverse_string;
		int pos_backup; //now s.[index] != ' '
		index++;		//now index == ' '; --index != ' '
		while (index > pre_index){
			//while (s[--index] == ' ');
			pos_backup = index;  //post_backup == ' ' 
			while (s[--index] != ' ' && index > pre_index);  //now s[index] == ' '
			if (index == pre_index)
				break;
			if (index > pre_index)
			{
				string tmp(s, index + 1, pos_backup - index - 1);
				reverse_string = reverse_string + tmp + " ";
			}
			
			//have completed a copy; set the initial condition: index == ' ', --index != ' '
			while (s[--index] == ' ');   //index != ' ';
			index++;						//index == ' ';  the next (index-1) is not ' '
		}
		if (index == pre_index)
		{
			//pos_backup = index + 1;
			string tmp(s, pre_index, pos_backup - pre_index);
			s = reverse_string + tmp;
		}
	}

};

int main()
{
	string s("th");
	//string s("   a   b ");
	cout << s.size() << endl;
	Solution tmp;
	tmp.reverseWords(s);

	std::cout<<s<<endl;
	cout << s.size() << endl;
	return 0;
}
 