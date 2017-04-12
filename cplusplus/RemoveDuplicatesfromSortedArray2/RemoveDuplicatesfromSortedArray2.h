class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(n<=1){
            return n;
        }
        int iCur = 0;
        int iRunner = 1;
        int iSize = n;
        while(iRunner < n){
            if(A[iRunner] == A[iCur]){
                A[++iCur] = A[iRunner];
                if(++iRunner < n)
                {
                    if(A[iRunner] == A[iCur])
                    {//
                        while(++iRunner < n && A[iRunner] == A[iCur]);
                        if(iRunner == n){
                            return ++iCur;
                        }
					}
                }
            }
            else{
                A[++iCur] = A[iRunner];
                iRunner++;
            }
        }
        
        return ++iCur;
        
    }
};

