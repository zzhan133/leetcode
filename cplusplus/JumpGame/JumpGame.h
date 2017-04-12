class Solution {
public:
	bool canJump(int A[], int n) {
		if(n <= 0)
			return false;
		if(n == 1){
			return true;
		}
		int iLastIndex = n-1;
		int iIndex = n-2;
		while(iIndex >= 0){  //2,3,1,1,4
			if( A[iIndex] + iIndex >= iLastIndex){
				iLastIndex = iIndex;
			}
			iIndex--;
		}
		if(iLastIndex == 0){
			return true;
		}
		return false;

	}
};

