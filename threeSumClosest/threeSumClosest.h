#include <vector>
#include <stdlib.h>
#include <algorithm>
using namespace std;

class Solution {
public:
    int twoSumClosest(vector<int> &num, int target, int iL, int iR){
        if(num[iL] + num[iL+1] >= target)
			return num[iL] + num[iL+1];
	if(num[iR] + num[iR-1] <= target)
		return num[iR] + num[iR-1];
	int iSum;
        while(iL < iR){
            iSum = num[iL] + num[iR];
            if(iSum == target){
                return iSum;
            }
            else if(iSum < target){
                iL++;
            }
            else //iSum > target
            {
                iR--;
            }
        }
        return iSum;
        
    }
    int threeSumClosest(vector<int> &num, int target) {
        sort(num.begin(), num.end());
        
        int threeSum =  num[0] + num[1] + num[2];

        int tmp = num.size()-1;
        if(num[tmp]+num[tmp-1]+num[tmp-2] <= target){
            return num[tmp]+num[tmp-1]+num[tmp-2];
        }
        
        for(int i = 0; i<num.size()-2; i++){
			int threeSumMin = num[i] + num[i+1] + num[i+2];
            if(threeSumMin >= target){
		        
		        if( abs(threeSumMin-target) < abs(threeSum - target))
             		return threeSumMin;
		        else
			        break;
            }

            int iTmp = target - num[i];
            int twoSum = twoSumClosest( num, iTmp, i+1, num.size()-1 );
            
            if(abs(twoSum - iTmp) < abs(threeSum - target)){
                threeSum = twoSum+num[i];
            }
        }
        return threeSum;
    }
};

