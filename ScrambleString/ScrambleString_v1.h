#include <string>
#include <vector>
using namespace std;

class Solution {
public:
   bool isScramble(string s1, string s2) {   
            // Start typing your C/C++ solution below   
            // DO NOT write int main() function   
            if(s1.size() != s2.size()) return false;   
            int A[26];   
            memset(A,0,26*sizeof(A[0]));   
            for(int i =0;i<s1.size(); i++)   
            {   
                 A[s1[i]-'a']++;   
            }   
            for(int i =0;i<s2.size(); i++)   
            {   
                 A[s2[i]-'a']--;   
            }   
            for(int i =0;i<26; i++)   
            {   
                 if(A[i] !=0)   
                 return false;   
            }   
            if(s1.size() ==1 && s2.size() ==1) return true;   
            for(int i =1; i< s1.size(); i++)   
            {   
                 bool result= isScramble(s1.substr(0, i), s2.substr(0, i))   
                      && isScramble(s1.substr(i, s1.size()-i), s2.substr(i, s1.size()-i));   
                 result = result || (isScramble(s1.substr(0, i), s2.substr(s2.size() - i, i))   
                      && isScramble(s1.substr(i, s1.size()-i), s2.substr(0, s1.size()-i)));   
                 if(result) return true;   
            }   
            return false;   
       }   
};

