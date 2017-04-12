#include <vector>
#include <string>
#include <iostream>
using namespace std;
class Solution {
public:
    int numDistinct(string S, string T) {
        int m = S.size() + 1;
        if(m == 1)
            return 1;
        int n = T.size() + 1;
        if(n == 1)
            return 0;
        vector< vector<int> > mmiStore(n, vector<int>(m, 0) );
        //The first row
        for(int i = 0; i<m; i++){
            mmiStore[0][i] = 1;
        }
        //The first col
        for(int j = 1; j< n; j++){
            mmiStore[j][0] = 0;
        }
        
        for(int i = 1; i< n; i++){
            for(int j = 1; j<m; j++){
                if(T[i-1] == S[j-1]){
                    mmiStore[i][j] = mmiStore[i-1][j-1] + mmiStore[i][j-1];
                }
                else{
                    mmiStore[i][j] = mmiStore[i][j-1];
                }
            }
        }
        return mmiStore[n-1][m-1];
        
    }
};


int main(){
	string str1( "rabbbit");
	string str2("rabbit");
	Solution instance;
	cout<<instance.numDistinct(str1, str2)<<endl;
	return 0;
}
