#include <map>
#include <vector>
#include <unordered_set>

using namespace std;

class Solution {
public:

	bool getLayer(map<int, unordered_set<string> > &layerStr, int iLayer, string &end, unordered_set<string> &dict, map<string, unordered_set<string> > &adjList, 	unordered_set<string> &visited){
		bool bResult = false;  //return value; if find end return true, else return false;

		for (auto it = layerStr[iLayer - 1].begin(); it != layerStr[iLayer - 1].end(); it++){
			visited.insert(*it);
		}

		for(auto it = layerStr[iLayer-1].begin(); it != layerStr[iLayer-1].end(); it++)
		{
			string str = *it;
			
			for ( char c = 'a'; c <= 'z'; c += 1 ) 
			{
				
				for ( unsigned pos = 0; pos < str.size(); pos += 1 ) 
				{
					char cBackup = str[pos];
					if(c == str[pos])
						continue;
					//c != str[pos]. change str
					str[pos] = c;

					if(str.compare(end) == 0)
					{
						bResult = true;   //find end
						adjList[end].insert(*it);  //*it is connected to end
						break;
					}

					else if (dict.count(str) == 1 && visited.count(str) == 0 )
					{
						
						layerStr[iLayer].insert(str);
						
						adjList[str].insert(*it);
						
					}
					
					str[pos] = cBackup; //restore str
				}
			}
			
		}

		return bResult;
	}

	void getVectorStrings(map<string, unordered_set<string> > &adjList, string strIndex, string start, vector<string> &vstr, vector<vector<string> > &vvsResult){
		if (strIndex.compare(start) == 0){
			
			vvsResult.push_back(vstr);
			return;
		}
		
		unordered_set<string> tmp = adjList[strIndex];
		for (auto it = tmp.begin(); it != tmp.end(); it++){
			vstr.insert(vstr.begin(), *it);
			getVectorStrings(adjList, *it, start, vstr, vvsResult);
			vstr.erase(vstr.begin());
		}
		return;
	}

    vector<vector<string> > findLadders(string start, string end, unordered_set<string> &dict) {
	    vector<vector<string> > vvsResult;
	    if(start.size() == 0)
		    return vvsResult;
       //All words have the same length.
	//All words contain only lowercase alphabetic characters.
	map<string, unordered_set<string> > adjList;
	map<int, unordered_set<string> > layerStr;

	unordered_set<string> visited;
	int iLayer = 0;
	layerStr[iLayer].insert(start);
	while( !getLayer(layerStr, ++iLayer, end, dict, adjList, visited) && layerStr[iLayer].size() != 0 ){
		;	
	}
	if(adjList[end].size() == 0)
		return vvsResult;
	//Restrict each layer
	vector<string> vstr;
	vstr.push_back(end);
	getVectorStrings(adjList, end, start, vstr, vvsResult);
	return vvsResult;

    }
};
