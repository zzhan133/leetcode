#pragma once
#include <string>
#include <vector>
#include <iostream>
#include <time.h>
#include <climits>

using namespace std;

class Solution {
public:
    vector<int> findSubstring(string S, vector<string> &L) {
        vector<int> reslt;
        if(S.size() == 0 || L.size() == 0)
            return reslt;
        //establish an array; if S contain any L's element, the value of this position will be the Index number of the element in L.
        //otherwise the value will be -1;
        vector<int> arrIndex(S.size(),-1);
        unsigned int strlength = L[0].size();
		unsigned int total_length = strlength*L.size();
        // set values of the array; The time complexity is m*n. m is the size of L; n is the size of S

         //clock_t start_time=clock();

		 //iterate the whole S
		 unsigned index = 0;
		 //the num to check
		 int creteriaSum = L.size()*(L.size() + 1) / 2;

		 while (index < S.size())
		 {
			 if (index + total_length > S.size())
				 break;
			 unsigned max_pos = 0;
			 unsigned min_pos = INT_MAX;
			 unsigned int found;
			 //There are 3 cases that the code will jump out the for loop sentence.
			 //1. found == string::npos. This situation will cause the code jump out the while loop
			 //2. max_pos - min_pos > total_length - strlength   jump out the for loop and change the value of index
			 //3. i == L.size() that means all substrings are found in a length of total_length-strlength
			 for (unsigned i = 0; i < L.size(); i++)
			 {
				 found = S.find(L[i], index);

				 unsigned int tmp = index;
				 while (found != std::string::npos &&arrIndex[found]!=-1 && arrIndex[found] < (int)i + 1) //two cases: 1. arrIndex[found] has been writtern in the for loop, then arrIndex[found] < i+1; 2. arrIndex[found] > i+1
				 {
					 tmp++;
					 if (tmp < S.size())
						 found = S.find(L[i], tmp);
					 else
						 found = std::string::npos;
				 }
				 if (found == std::string::npos)
					 break;

				 if (found > max_pos)
					 max_pos = found;
				 if (found < min_pos)
					 min_pos = found;
				 if (max_pos - min_pos > total_length - strlength)
				 {
					 index = max_pos - total_length + strlength;
					 break;
				 }


				 unsigned int tmp2 = index;
				 while((found - min_pos)%L[0].size() != 0)
                 {

                     tmp2++;
                     if (tmp2 < S.size() && found - min_pos + strlength < total_length)
						 found = S.find(L[i], tmp2);
					 else
                     {
                         break;
                     }
                 }
                 if (found == std::string::npos)
					 break;
				 arrIndex[found] = i + 1;
			 }
			 if (found == std::string::npos)
				 break;
			 if (max_pos - min_pos <= total_length - strlength)
			 {

				 int sum = 0;
				 for (unsigned j = min_pos; j < arrIndex.size() && arrIndex[j] != -1 && j<min_pos + strlength*L.size(); j += strlength)
				 {
					 sum += arrIndex[j];
				 }
				 if (sum == creteriaSum)
				 {
					 reslt.push_back(min_pos);
				 }
				 index = min_pos + 1;
			 }
		 }


        /*for(unsigned i = 0; i<L.size(); i++)
        {
            int pos = 0;
			unsigned int found;
            unsigned int found = S.find(L[i], pos);
            while(found != std::string::npos)
            {
                arrIndex[found] = i+1;
                pos++;
                found = S.find(L[i], pos);
            }
        }  */



		/*
		clock_t end_time=clock();
		cout<< "fount Running time is: "<<static_cast<double>(end_time-start_time)/CLOCKS_PER_SEC*1000<<"ms"<<endl;//
		std::swap(start_time, end_time);

		*/

        /*int creteriaSum = L.size()*(L.size() + 1)/2;
        for(unsigned i = 0; i<arrIndex.size(); i++)
        {
            if(arrIndex[i] != -1)
            {
                int sum = 0;
                for(unsigned j = i; j < arrIndex.size()&&arrIndex[j] != -1&&j<i+strlength*L.size(); j+=strlength)
                {
                    sum+=arrIndex[j];
                }
                if(sum == creteriaSum)
                {
                    reslt.push_back(i);
                }
            }
        }*/

		/*
         end_time=clock();
    cout<< "Check Running time is: "<<static_cast<double>(end_time-start_time)/CLOCKS_PER_SEC*1000<<"ms"<<endl;//输出运行时间
	*/
        return reslt;
    }
};
