#include <string>
using namespace std;

class Solution {
public:
    void add(bool _add1, bool _add2, bool _add3, bool &_result, bool &_g){
        //There are four situations. List all of them as follows
        if(_add1 == false && _add2 == false && _add3 == false)     //000
	{
		_result = false;
		_g = false;
	}
	else if(_add1 == false && _add2 == false && _add3 == true) // 001
	{
		_result = true;
		_g = false;
	} 
	else if(_add1 == false && _add2 == true && _add3 == false) // 010
	{
		_result = true;
		_g = false;
	} 
	else if(_add1 == false && _add2 == true && _add3 == true ) // 011
	{
		_result = false;
		_g = true;
	} 
	else if(_add1 == true && _add2 == false && _add3 == false) // 100
	{
		_result = true;
		_g = false;
	} 
	else if(_add1 == true && _add2 == false && _add3 == true) // 101
	{
		_result = false;
		_g = true;
	} 
	else if(_add1 == true && _add2 == true && _add3 == false) // 110
	{
		_result = false;
		_g = true;
	} 
	else //if(_add1 == true && _add2 == true && _add3 == true) //111
	{
		_result = true;
		_g = true;
	} 
        
   }
    bool char2bool(char a)
    {
	    if(a == '1')
		    return true;
	    else
		    return false;
    }
	char bool2char(bool a){
		if(a)
			return '1';
		else
			return '0';
	}


    string addBinary(string a, string b) {
	int iA = a.size();
	int iB = b.size();
	if(iA == 0)
		return b;
	if(iB == 0)
		return a;
	string strResult;
	bool bG = false;
	bool bR = false;
	int iSize = std::min(iA, iB);

	for ( int i = 0; i < iSize; i += 1 ) {
		bool add1 = char2bool(a[iA-i-1]);
		bool add2 = char2bool(b[iB-i-1]);
		bool add3 = bG;
		add(add1, add2, add3, bR, bG);
		char c = bool2char(bR);
		strResult.insert(strResult.begin(), c);
	}
	if(iA > iSize){
		for ( int i = 0; i < iA-iSize; i += 1 ) {
			bool add1 = char2bool(a[iA-iSize-i-1]);
			bool add2 = false;
			bool add3 = bG;
			add(add1, add2, add3, bR, bG);
			char c = bool2char(bR);
			strResult.insert(strResult.begin(), c);
		}
		
	}

	if(iB > iSize){
		for ( int i = 0; i < iB-iSize; i += 1 ) {
			bool add1 = char2bool(b[iB-iSize-i-1]);
			bool add2 = false;
			bool add3 = bG;
			add(add1, add2, add3, bR, bG);
			char c = bool2char(bR);
			strResult.insert(strResult.begin(), c);
		}
		
	}
	
	if(bG)
	{
		strResult.insert(strResult.begin(), '1');

	}
		
	return strResult;
    }
};

