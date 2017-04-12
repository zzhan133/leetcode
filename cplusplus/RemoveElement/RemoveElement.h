class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int lpos = -1;
        int rpos = n;
        while(lpos<rpos){
            while(++lpos < rpos && A[++lpos] != elem);
            while(lpos<=--rpos && A[rpos] == elem ); //1. if all elements are not equal to elem.  return rpos+1;
                                                    //1. if one or more elements are equal to elem. return rpos +1;
            if(lpos<rpos)
            {
                swap(A[lpos],A[rpos]);
            }
            
        }
        return rpos+1;
    }
};

