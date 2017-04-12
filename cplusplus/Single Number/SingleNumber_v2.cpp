#include	<iostream>
#include	<algorithm>
using namespace std;

class Solution {
public:
    int partition(int A[], int left, int right)
    {
        int i = left-1;
        int j = right;
        int tmp = A[right];
        while(i<j)
        {
            while(A[++i] <= tmp && i<j);
            while(A[--j] > tmp && i<j);
            if(i<j)
                swap(A[i], A[j]); 
        }
        swap(A[i], A[right]);
        return i;
    }
    int singleNumber(int A[], int left, int right)
    {
        if(left == right)
            return A[left];
        int mid = (left+right)/2;
        if(A[mid] == A[right])
	    {
		    swap(A[mid],A[right-1]);
		    return singleNumber(A,left, right-2);
	    }

        std::swap(A[mid], A[right]);
        int partitionNum = partition(A, left, right);
        if((right-partitionNum)%2 == 1)
            return singleNumber(A,partitionNum+1, right);
        else
            return singleNumber(A, left, partitionNum);
        
    }
    int singleNumber(int A[], int n) {
        return singleNumber(A, 0, n-1);
    }
};
int main()
{
	int A[] = {1,2,1,3,3};
	Solution instance;
	cout << instance.singleNumber(A,5) << endl;
	
	return 0;
}

