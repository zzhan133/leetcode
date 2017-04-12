/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    bool isLess(Interval &a, Interval &b){
        if(a.start <= b.start)
            return true;
        return false
    }
    int partition(vector<Interval> &intervals, int _iB, int _iE){
        if(_iB >= _iE)
            return _iB;
        Interval tmp = intervals[_iE];
        int iL = _iB - 1;
        int iR = _iE;
        while(iL < iR){
            while( isLess(intervals[++iL], tmp) && iL < iR );
            while( isLess(tmp, intervals[--iR]) && iL < iR );
            if(iL < iR){
                swap( intervals[iL], intervals[iR] );
            }
        }
        swap( intervals[iL], intervals[_iE] );
        return iL;
    }
    void sortIntervals(vector<Interval> &intervals, int _iB, int _iE){
        //use quick sort method to sort the intervals  
        if(_iB >= _iE)
            return;
        int iPartition = partition(intervals, _iB, _iE);
        sortIntervals(intervals, _iB, iPartition-1);
        sortIntervals(intervals, iPartition+1, _iE);
    }
    
    
    vector<Interval> merge(vector<Interval> &intervals) {
        int iSize = intervals.size();
        if(iSize == 0)
            return intervals;
        //sort the intervals first
        sortIntervals(intervals, 0, iSize - 1);
        //iterate the whole intervals one by one
        vector<Interval> vR;
        vR.push_back(intervals[0]);
        for(int i = 1; i< iSize; i++){
            //determine if those adjacent two intervals are overlapping
            
            if(intervals[i].start <= vR.back().end){
                Interval tmp(vR.back().start, intervals[i].end);
                vR.pop_back();
                vR.push_back(tmp);
            }
            else{
                vR.push_back(intervasl[i]); 
            }
        }
    }
};

