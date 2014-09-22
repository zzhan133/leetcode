#include	<string>
#include	<algorithm>

using namespace std;

class Solution {
public:
    int minDistance(string word1, string word2) {
        int num1 = (int)word1.size();
        int num2 = (int)word2.size();
        if(num1 == 0)
            return num2;
        if(num2 == 0)
            return num1;
        int** arr = new int*[num1+1];
        for(int i = 0; i<num1+1; i++)
        {
            arr[i] = new int[num2+1];
        }
        
        for(int i = 0; i <num2+1; i++)
        {
            arr[0][i] = i;
        }
        for(int j = 0; j<num1+1; j++)
        {
            arr[j][0] = j;
        }
        
        //assign a value to every block of the arr
        //using two for loop
        for(int i = 1; i<num1+1; i++)
        {
            for(int j = 1; j<num2+1; j++)
            {
                //1.if the char in word1 is equal to the char in word2
                if(word1[i-1] == word2[j-1])
                {
                    arr[i][j] = std::min(arr[i-1][j-1], 1+std::min(arr[i-1][j], arr[i][j-1]));
                }
                //2.if they are not equal
                else
                {
                    arr[i][j] =1 + std::min(arr[i-1][j-1], std::min(arr[i-1][j], arr[i][j-1]));
                }
            }
        }

		int result = arr[num1][num2];
        for(int i = 0;  i<num1+1; i++)
        {
            delete []arr[i];
        }
        
        delete []arr;
        arr = nullptr;
		return result;
    }
};

