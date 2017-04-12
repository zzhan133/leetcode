class Solution {
public:
    int getDigits(int x){
        int num = 0;
        while(x){
            x = x/10;
            num++;
        }
        return num;
    }
    int getVal(int x, int num){
        int n = 1;
        while(n != num){
            x = x/10;
            n++;
        }
        return x%10;
    }
    bool isPalinWithIndex(int x, int iLeft, int iRight){
        if(iLeft <= iRight)
            return true;
        int iLeftNum = getVal(x, iLeft);
        int iRightNum = getVal(x, iRight);
        if(iLeftNum != iRightNum)
            return false;
        return isPalinWithIndex(x, iLeft-1, iRight+1);
    }
    bool isPalindrome(int x) {
     if(x<0)
     {
         return false;
     }
     
        return isPalinWithIndex(x, getDigits(x), 1);
    }
};

