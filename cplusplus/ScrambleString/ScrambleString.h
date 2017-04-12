#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    bool isSameLetters(string s1, string s2){
        vector<int> viRecord(128, 0);
        for(unsigned i = 0; i<s1.size(); i++){
            viRecord[s1[i]]++;
        }
        
        for(unsigned i = 0; i<s2.size(); i++){
            if(viRecord[s2[i]] == 0)
                return false;
            viRecord[s2[i]]--;
        }
        
        for(unsigned i = 0; i<128; i++){
            if(viRecord[i] != 0)
                return false;
        }
        
        return true;
    }
    bool isScramble(string s1, string s2) {
        if(s1.size() == 0)
            return true;
        if(s1 == s2)
            return true;
        
        //trim the front
            if(s1[0] == s2[0]){
                return isScramble(s1.substr(1), s2.substr(1) );
            }
        
        //trim the back
        unsigned int uSize = s1.size() - 1;
        if(s1[uSize] == s2[uSize]){
            return isScramble( s1.erase(uSize), s2.erase(uSize) );
        }

		if (s1[0] == s2[uSize])
		{
			return isScramble( s1.substr(1), s2.erase(uSize) );
		}

		if (s2[0] == s1[uSize])
		{
			return isScramble( s2.substr(1), s1.erase(uSize) );
		}
        
		if (isSameLetters(s1, s2))
		{
			if (s1.size() <= 3)
			{
				return true;
			}
		}
		else{
			return false;
		}

        for(unsigned i=2; i<=s1.size(); i++){
            string strS1First = s1.substr(0, i);
            
            string strS2Front = s2.substr(0,i);
            string strS2Last = s2.substr(s1.size() - i);
            
            if(isScramble(strS1First, strS2Front)){
                return isScramble(s1.substr(i), s2.substr(i));
            }
            
            if(isScramble(strS1First, strS2Last)){
                return isScramble(s1.substr(i), s2.erase(s1.size() - i));
            }
            
        }
        
        return false;
    }
};

