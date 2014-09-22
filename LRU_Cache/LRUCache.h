#include <map>
#include <vector>
using namespace std;

class LRUCache{
public:
    LRUCache(int capacity) {
        cap = capacity;
        timing = INT_MIN;
    }
    
    int get(int key) {
        if(miiCache.count(key) == 1){
            viKeyNum[key] = timing++;
            return miiCache[key];
        }
        else
            return -1;
    }
    
    void set(int key, int value) {
        if(miiCache.count(key) == 1){
            viKeyNum[key] = timing++;
            miiCache[key] = value;
        }
        else{
            if(viKeyNum.size() == cap){
                //find the least used item
                int minNum = INT_MAX;
                int minKey;
                map<int, int>::iterator it = viKeyNum.begin();
                while(it != viKeyNum.end()){
                    if(it->second < minNum){
                        minNum = it->second;
                        minKey = it->first;
                    }
                    it++;
                }
                miiCache.erase(minKey);
                viKeyNum.erase(minKey);
                
                miiCache[key] = value;
                viKeyNum[key] = timing++;
            }
            else{  //still has empty slot
                miiCache[key] = value;
                viKeyNum[key] = timing++;
            }
            
        }
    }
private:
    map<int, int> miiCache; //key, value
    map<int, int> viKeyNum; //key number
    int cap;
    int timing;
};

