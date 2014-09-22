#include <vector>
#include <string>
#include <map>
#include <set>
#include <unordered_set>

using namespace std;

class Solution {
public:
	void getString(map<int, set<int> > &LinkedList, int key, string str, int iLevel, vector<string> &vstrResult)
	{
		set<int> tmp = LinkedList[key];
		for(set<int>::iterator it = tmp.begin(); it != tmp.end(); it++){
			if(*it + iLevel == str.size() -1){   //*it+1 is the next step
				vstrResult.push_back(str);
			}
			else{
				string strSpace = " ";
				str.insert(*it+iLevel+1, strSpace);
				getString(LinkedList, *it+1, str, iLevel+1, vstrResult);
				str.erase(*it+iLevel+1,1);
			}
		}
	}

    vector<string> wordBreak(string s, unordered_set<string> &dict) {

	vector<string> vstrResult;
 	      //get the status array
	      //get the adjacent List
	int iSize = (int) s.size();
	vector<bool> vbStatus(iSize, false);

	map<int, set<int> > LinkedList;

	
	for ( int i = iSize-1; i >= 0; i -= 1 ) {
		for(int j=i; j<iSize; j++)
		{
			if( (j == iSize-1 || vbStatus[j+1]) && dict.count(s.substr(i, j-i+1)) )
			{
				vbStatus[i] = true;
				LinkedList[i].insert(j);
			}
		}
	}

	if(vbStatus[0] == false)
		return vstrResult;

	getString(LinkedList, 0, s, 0, vstrResult);	

    return vstrResult;
	}
};
