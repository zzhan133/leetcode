#pragma once
#include <vector>
using namespace std;
class Solution {
public:
    int combine(int n, int k)
    {
        if(n-k<k)
            k = n-k;
        long int reslt = 1;
        for(int i = n-k+1; i<=n; i++)
        {
            if(i%(i+k-n) == 0)
                reslt = reslt*(long int)(i/(i+k-n));
            else if(reslt%(i+k-n) == 0)
            {
                reslt = reslt/(i+k-n)*i;
            }
            else
                reslt = reslt*(long int)i/(long int)(i+k-n);
        }
        return (int)reslt;
    }
    vector<int> getRow(int rowIndex) {
        if(rowIndex < 0)
        {
            vector<int> reslt;
            return reslt;
        }
        if(rowIndex == 0)
        {
            vector<int> reslt;
            reslt.push_back(1);
            return reslt;
        }
        if(rowIndex == 1)
        {
            vector<int> reslt;
            reslt.push_back(1);
            reslt.push_back(1);
            return reslt;
        }
        vector<int> reslt(rowIndex+1, 0);
        vector<int> tmp(rowIndex+1, 0);
        reslt[0] = 1;
        tmp[0] = 1;
        tmp[1] = 1;
        for(int i = 2; i<=rowIndex; i++)
        {

                reslt[i] = 1;
                for(int j = 1; j<i;j++)
                {
                    reslt[j] = tmp[j-1]+tmp[j];
                }
                swap(reslt, tmp);
        }
        return tmp;
    }
};

/*
class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> > reslt;
        if(k>n || n<=0 || k<=0)
            return reslt;
        if(k==n)
        {
            vector<int> tmp(n);
            for(int i=0;i<n;i++)
            {
                tmp.push_back(i+1);
            }
            reslt.push_back(tmp);
            return reslt;
        }
        //reslt can  be calculated as combine(n-1, k-1) + combine(n-1, k)
        vector<vector<vector<vector<int> > > > s(n, vector<vector<vector<int> > >(k)); //s represents all the result of combine

        for(int i=0; i<n; i++)
        {
            vector<vector<int> > element;
            for(int j=0;j<=i;j++)
            {
                vector<int> single;
                single.push_back(j+1);
                element.push_back(single);
            }
            s[i][0] = element;
        }
        //the initial condition

        if(k == 1)
            return s[n-1][k-1];


        for(int i=1; i<n;i++)
        {
            for(int j=1;j<k&&j<=i;j++)
            {
                if(j>0)
                {
                    s[i][j] = s[i-1][j-1];
                    for(unsigned k = 0; k<s[i-1][j-1].size(); k++)
                    {
                        s[i][j][k].push_back(i+1);
                    }
                }
                if(i-1 >= j)
                    s[i][j].insert(s[i][j].end(),s[i-1][j].begin(),s[i-1][j].end());
            }
        }
        return s[n-1][k-1];
    }
};
*/
