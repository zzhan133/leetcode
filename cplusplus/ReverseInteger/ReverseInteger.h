#pragma once
#include <stack>
#include <climits>
using namespace std;
class Solution {
public:
    int reverse(int x) {
        if(x==0)
            return x;
        int tmp = x;
        if(x<0)
            tmp = -x;
        stack<int> digits;
        //divisor, quotient, remainder
        int rmnder;
        while(tmp != 0)
        {
            rmnder = tmp%10;
            tmp = tmp/10;
            digits.push(rmnder);
        }
        long result = 0;
        int mul = 1;
        while(!digits.empty())
        {
            result += digits.top()*mul;
            digits.pop();
            mul = mul*10;
        }
        if(result < INT_MAX)
        {
            if(x < 0)
                return (int)(0-result);
            else
                return (int)result;
        }
        else
            {
                if(x>0)
                    return INT_MAX;
                else
                    return INT_MIN;
            }

    }
//    return (int)result;

};

