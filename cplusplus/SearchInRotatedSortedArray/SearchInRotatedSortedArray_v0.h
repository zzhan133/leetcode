class Solution {
public:
    int searchRecur(int A[], int iL, int iR, int target){
        if(iL > iR){
            return -1;
        }
        if(iL == iR){
            if(A[iL] != target)
                return -1;
        }
        
        int mid = (iL + iR)/2;
        if(A[mid] == target){
            return mid;
        }
        else if(A[mid] < target){
            if(A[iL] < A[iR]){
                return searchRecur(A, mid+1, iR, target);  //array is a sorted array without pivot
            }
            if(A[iL] <= A[mid]){
                return searchRecur(A, mid+1, iR, target);
            }
            
            if(A[iL] > A[mid]){
                if(target <= A[iR]){
                    return searchRecur(A, mid+1, iR, target);
                }
                else{
                    return searchRecur(A, iL, mid-1, target);
                }
                
            }
        }
        else //(A[mid] > target)
        {
            
            if(A[iL] < A[iR]){
                return searchRecur(A, iL, mid-1, target);  //array is a sorted array without pivot
            }
            
            if( A[mid] < A[iR]){
                return searchRecur(A, iL, mid-1, target);
            }
            
            if(A[mid] > A[iR]){
                if(target < A[iL]){
                    return searchRecur(A, mid+1, iR, target);
                }
                else{
                    return searchRecur(A, iL, mid-1, target);
                }
            }
            return -1;
        }
    }
    
    int search(int A[], int n, int target) {
        return searchRecur(A, 0, n-1, target);
    }
};

