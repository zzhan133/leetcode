class Solution {
public:
	vector<char> getChars(char c){
		vector<char> vc;
		static char arr[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		unsigned i = (c - 50)*3;
		if (i <= 12)
		{
			vc.assign(arr+i,arr+i+3);
		}
		else if (i == 15)
		{
			vc.assign(arr+i,arr+i+4);
		}
		else if (i == 18)
		{
			vc.assign(arr+i+1,arr+i+4);
		}
		else if (i == 21)
		{
			vc.assign(arr+i+1,arr+i+5);
		}
		
			return vc;
	}
		void getLetter(string &digits, string &str, unsigned int iLeft, vector<string> &vstr){
			if(str.size() == digits.size()){
				vstr.push_back(str);
				return;
			}
			vector<char> vc = getChars(digits[iLeft]);
			for(auto it = vc.begin(); it != vc.end(); it++){
				str.push_back(*it);
				getLetter(digits, str, iLeft+1, vstr);
				str.pop_back();
			}
		}
		vector<string> letterCombinations(string digits) {
			vector<string> vstr;
			if(digits.size() == 0){
			    vstr.push_back("");
			    return vstr;
			}
			string str;
			getLetter(digits, str, 0, vstr);
			return vstr;
		}
	};

