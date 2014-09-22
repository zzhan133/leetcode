/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
	void dealWithNeighbors(UndirectedGraphNode *newNode, UndirectedGraphNode *oldNode, map<int, UndirectedGraphNode*> &uiMap, unordered_set<int> &uiVisited){
		if(uiVisited.count(oldNode->label) != 0){
			return;
		}

		uiVisited.insert(oldNode->label);

		for(auto it = oldNode->neighbors.begin(); it != oldNode->neighbors.end(); it++){
			int tmp = (*it)->label;
			UndirectedGraphNode *pTmp;
			if(uiMap.count(tmp) == 0){
				pTmp = new UndirectedGraphNode(tmp);
				
				uiMap[tmp] = pTmp;
			}
			else{
				pTmp = uiMap[tmp];

			}

			newNode->neighbors.push_back(pTmp);
			dealWithNeighbors( pTmp, *it, uiMap, uiVisited);
		}
	}
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
 	//Breadth Search First
	if(node == NULL)
		return NULL;
	UndirectedGraphNode *pReturn = new UndirectedGraphNode(node->label);       
	//deal with the neighbors
	map<int, UndirectedGraphNode*> uiMap;

	uiMap[node->label] = pReturn;
	
	//using an unordered_set to record which node is traversed
	unordered_set<int> uiVisited;
	

	dealWithNeighbors(pReturn, node, uiMap, uiVisited);

	return pReturn;

    }
};
