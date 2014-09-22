class Solution {
public:
/*	int duplicateIndex(int A[], int iL, int iR, int target){
		if(iR == 0)
			return iR;

			if (A[iR-1] != target)
			{
				return iR;
			}
			
		int mid = (iL + iR) / 2;
		if(A[mid] == target)
			return duplicateIndex(A, iL, mid, target);
		else
		{
			return duplicateIndex(A, mid+1, iR-1, target);
		}
	}
*/
    bool searchRecur(int A[], int iL, int iR, int target)
	{
        if(iL > iR)
		{
            return false;
        }
        if(iL == iR)
		{
            if(A[iL] != target)
                return false;
        }
        
        int mid = (iL + iR)/2;
        if(A[mid] == target)
		{
            return true;
        }

		if(A[iL] < A[iR])
		{
			if (target < A[mid])
			{
				return searchRecur(A, iL, mid-1, target);
			} 
			else
			{
				return searchRecur(A, mid+1, iR, target);  //array is a sorted array without pivot
			}
		}

		//A[iL] == A[iR]
		else if (A[iL] == A[iR])
		{
			if (target == A[iL])
			{
				return true;
			}
			return searchRecur(A, iL+1, iR-1, target);
		}

		//A[iL] > A[iR]
		else
		{
			if (A[iL] == A[mid])
			{
				return searchRecur(A, mid+1, iR, target);
			} 
			else if(A[iL] < A[mid])
			{
				if (target < A[iL])
				{
					return searchRecur(A, mid+1, iR, target);
				}
				else if (target == A[iL])
				{
					return true;
				}
				else if (target <= A[mid] && target > A[iL])
				{
					return searchRecur(A,iL+1, mid, target);
				}
				else
				{
					return searchRecur(A, mid+1, iR, target);
				}
			}
			else //A[iL] > A[mid]
			{
				if(A[mid] == A[iR])
				{
					return searchRecur(A, iL, mid-1, target);
				}
				else if (A[mid] < A[iR])
				{
					if (target < A[mid] || target > A[iR])
					{
						return searchRecur(A, iL, mid-1, target);
					}
					if (A[mid] < target && target<=A[iR])
					{
						return searchRecur(A, mid+1, iR, target);
					}

				}
			}
			
		}
			
		return false;
        
    }
    
    bool search(int A[], int n, int target) {
        return searchRecur(A, 0, n-1, target);
    }
};

