#include <string>
#include <map>
using namespace std;
class Solution {
public:
    int recursive_calc(string s, map<string, int> &convert)
    {
        if(0==s.size())
            return 0;
        if(1==s.size())
            {
                return convert[s];
            }
        string str = s.substr(0,2);
        if(convert.count(str))
        {
            string tmp = s.substr(2,s.size()-2);
            return convert[str] + recursive_calc(tmp, convert);
        }
        else
        {
			str = s.substr(0, 1);
            string tmp = s.substr(1,s.size() - 1);
            return convert[str] + recursive_calc(tmp, convert);
        }
    }
    int romanToInt(string s) {
        if(0==s.size())
            return 0;
        map<string, int> convert;
        convert["I"] = 1;
        convert["V"] = 5;
        convert["X"] = 10;
        convert["L"] = 50;
        convert["C"] = 100;
        convert["D"] = 500;
        convert["M"] = 1000;
        convert["IV"] = 4;
        convert["IX"] = 9;
        convert["XL"] = 40;
        convert["XC"] = 90;
        convert["CD"] = 400;
        convert["CM"] = 900;
        return recursive_calc(s, convert);
    }
};

