#include	<iostream>
#include	<algorithm>
using namespace std;
class Solution {
public:
    int partition(int A[], int lpos, int rpos)
    {
        if(lpos>=rpos)
            return lpos;
        int backup = rpos;
//	int lbackup = lpos;
        int tmp = A[rpos];
        lpos--;
        while(lpos < rpos)
        {
            while(A[++lpos] <= tmp && lpos<rpos );  //rpos is always point to a value that is equal or greater than tmp
            while(A[--rpos] > tmp && lpos<rpos );
            if(lpos < rpos)
            {
                std::swap(A[lpos], A[rpos]);
            }
        }
	/*  ;
	if(A[lpos] == A[backup] && lpos != backup)
	{
		std::swap(A[lpos],A[backup-1]);
		return backup;
	}
	if(lpos == backup)
		return -1;	*/
        std::swap(A[lpos], A[backup]);
        return lpos;
    }
    int singleNumber(int A[], int lpos, int rpos)
    {
        if(rpos <= lpos)
            return lpos;
        int mid = (lpos+rpos)/2;
	if(A[mid] == A[rpos])
	{
		 std::swap(A[mid], A[rpos-1]);
		 if((A[mid] == A[rpos]))
		{
			std::swap(A[mid], A[rpos-2]);
			return singleNumber(A,lpos, rpos-3);
		}
	}
        std::swap(A[mid], A[rpos]);
        int pos = partition(A, lpos, rpos);
	/*  if(pos == -1)
		return rpos;
	if(pos == rpos)
		return singleNumber(A, lpos, rpos-2);*/
        if((rpos - pos)%3 == 1)
        {
            return singleNumber(A, pos+1, rpos);
        }
        else
            return singleNumber(A,lpos, pos);
        
    }
    int singleNumber(int A[], int n) {
        if(n == 1)
            return A[0];
        else
            return A[singleNumber(A, 0, n-1)];
    }
};
int main()
{
	int A[] = {1,3,2,1,1,3,3};
	Solution instance;
	cout << instance.singleNumber(A,7) << endl;
	
	return 0;
}
