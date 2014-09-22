#include <vector>
using namespace std;

class Solution {
public:
    vector<int> searchVal(int A[], int iL, int iR, int target)
    {
        vector<int> viR(2, -1);
        if(iL > iR){
            return viR;
        }
        if(A[iL] == target && A[iR] == target){
            viR[0] = iL;
            viR[1] = iR;
            return viR;
        }
        
        int mid = (iL + iR) / 2;
        if(A[mid] == target){
            if(A[iL] == target){
                viR[0] = iL;
                vector<int> viRigh = searchVal(A, mid+1, iR, target);
                if(viRigh[0] == -1){
                    viR[1] = mid;
                    return viR;
                }
                else{
                    viR[1] = viRigh[1];
                    return viR;
                }
            }
            else if(A[iR] == target){
                viR[1] = iR;
                vector<int> viLeft = searchVal(A, iL, mid-1, target);
                if(viLeft[0] == -1 ){
                    viR[0] = mid;
                    return viR;
                }
                else{
                    viR[0] = viLeft[0];
                    return viR;
                }
            }
            vector<int> viLeft = searchVal(A, iL, mid-1, target);
            vector<int> viRigh = searchVal(A, mid+1, iR, target);
            if(viLeft == viR && viRigh == viR){
                viR[0] = mid;
                viR[1] = mid;
                return viR;
            }
            if(viLeft == viR){
                viR[0] = mid;
                viR[1] = viRigh[1];
                return viR;
            }
            if(viRigh == viR){
                viR[0] = viLeft[0];
                viR[1] = mid;
                return viR;
            }
            
            viR[0] = viLeft[0];
            viR[1] = viRigh[1];
            return viR;
        }
        else if(target < A[mid]){
            return searchVal(A, iL, mid-1, target);
        }
        else{  //target > A[mid]
            return searchVal(A, mid+1, iR, target);
        }
    }
    vector<int> searchRange(int A[], int n, int target) {
        return searchVal(A, 0, n-1, target); 
    }
};
