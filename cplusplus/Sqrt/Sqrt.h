class Solution {
public:
    int sqrt(int x) {
	//the up limitation is: 46341
	const int iMAX = 46340;
        if(x < 0)
            return -1;
        if(x == 0 || x == 1)
            return x;
	if(x >= iMAX*iMAX)
	    return iMAX;

        int a = 1; 
        while(a*a <= x && 2*a <= iMAX){
            a = 2*a;
        }
        int iLow = a/2;
	int iHigh = a;
	if(iLow*iLow == x)
		return iLow;
	if(2*a > iMAX && a*a <= x){
		iLow = a;
		iHigh = iMAX;
	}
	int iMid = (iLow+iHigh)/2;
	while(iMid != iLow){
		int iTmp = iMid*iMid;
		if(iTmp == x){
			return iMid;
		}
		else if(iTmp > x){
			iHigh = iMid;
		}
		else{
			iLow = iMid;
		}
		iMid = (iLow+iHigh)/2;
	}
	return iMid;

        
    }
};

