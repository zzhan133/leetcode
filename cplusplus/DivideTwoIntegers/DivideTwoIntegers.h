class Solution {
 public:
	 int divideWithoutFlag(int dividend, int divisor){
		 if(divisor > dividend || dividend == 0){
			 return 0;
		 }

		 int backup = divisor;

		 int iResult = 1;
		 while(divisor < dividend && divisor < 1073741824){
			 divisor = divisor << 1;
			 iResult = iResult << 1;
		 }

		 if(divisor == dividend){
			 return iResult;
		 }

		 if(divisor >= 1073741824 && divisor < dividend ){
			 return iResult + divideWithoutFlag(dividend-divisor,backup);
		 }

		 divisor = divisor >> 1;
		 iResult = iResult >> 1;
		 return iResult + divideWithoutFlag(dividend-divisor, backup) ;

	 }
	 int divide(int dividend, int divisor) {

		 if(dividend == 0 || divisor == 0){
			 return 0;
		 }

		 if(divisor == 1){
			 return dividend;
		 }

		 if(divisor == -1){
			 return 0 - dividend;
		 }


		 bool bFlag = true;

		 if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
			 bFlag = false;
		 }

		 if(divisor == INT_MIN){
			 if(dividend == divisor){
				 return 1;
			 }
			 else{
				 return 0;
			 }
		 }

        if (dividend == INT_MIN)
		 {
			 if (bFlag)
			 {
				 dividend -= divisor;
				 return 1 + divideWithoutFlag(abs(dividend), abs(divisor));
			 }
			 else{
				dividend += divisor;
				return 0 - divideWithoutFlag(abs(dividend), abs(divisor)) - 1;
			 }
		 }

		 int tmp = divideWithoutFlag(abs(dividend), abs(divisor));
		 return bFlag ? tmp : (0-tmp);
	 }
 };
