#include <vector>
#include <stdlib.h>
#include <algorithm>
using namespace std;

class Solution {
public:
  int threeSumClosest(vector<int> &num, int target) {  
    // Start typing your C/C++ solution below  
    // DO NOT write int main() function  
    std::sort(num.begin(), num.end());  
    int len = num.size();  
    int minV = INT_MAX, record;  
    for(int i =0; i< len; i++)  
    {        
      int start = i+1, end =len-1;             
       while(start<end)  
       {  
         int sum = num[i] + num[start] + num[end];  
         if(sum == target)  
         {   
           minV = 0;  
           record = sum;  
           break;  
         }  
         if(sum < target)  
         {  
           if(target-sum < minV)  
           {  
             minV = target-sum;  
             record = sum;  
           }  
           start++;            
         }  
         else  
         {  
           if(sum-target < minV)  
           {  
             minV = sum - target;  
             record = sum;  
           }  
           end--;  
         }  
       }        
       while(i<len-1 && num[i] == num[i+1]) i++;  
     }  
     return record;  
}
  
};


