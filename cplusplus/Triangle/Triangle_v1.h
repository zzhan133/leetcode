class Solution {
public:
	int minimumTotal(vector<vector<int> > &triangle) {
		unsigned uLevel = triangle.size();
		if(uLevel == 0)
			return 0;
		unsigned uNum = triangle[uLevel-1].size(); 
		//create an array to store the distances of every node
		vector<int> viDis( triangle[uLevel-1] );
		vector<int> viLevel(uNum, uLevel );


		while(true){
			//find the min Dis
			int minDis = INT_MAX;
			int minPos = 0;
			for(unsigned i = 0; i < uNum; i++){
				if(minDis > viDis[i]){
					minDis = viDis[i];
					minPos = i;
				}
			}

			viLevel[minPos] = viLevel[minPos] - 1;
			if( viLevel[minPos] == 1)
				return minDis+triangle[0][0];


			int adder = 0;
			if(minPos == 0)
				adder = triangle[viLevel[minPos] - 1][minPos];
			else if(minPos == triangle[viLevel[minPos]- 1].size())
				adder =  triangle[viLevel[minPos]- 1][minPos-1];
			else{
				adder = min(triangle[viLevel[minPos]- 1][minPos], triangle[viLevel[minPos]- 1][minPos-1]);
			}


			viDis[minPos] += adder;



		}

	}
};


