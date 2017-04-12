class Solution {
public:
	int minimumTotal(vector<vector<int> > &triangle) {
		unsigned uLevel = triangle.size();
		if(uLevel == 0)
			return 0; 
		//create an array to store the distances of every node

		vector<int> viPreDis( triangle[uLevel-1] );

		while(viPreDis.size() != 1){
			vector<int> viCurDis(viPreDis.size() - 1);

			for(unsigned i = 0; i < viCurDis.size(); i++){

				int adder = min(viPreDis[i], viPreDis[i+1]);
				int val = triangle[viCurDis.size()-1][i];
				viCurDis[i] = adder + val;				
			}
			swap(viCurDis, viPreDis);
		}

		return viPreDis[0];

	}
};


