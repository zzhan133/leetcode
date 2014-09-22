#include	<vector>
#include	<map>
#include	<string>
#include	<algorithm>
#include	<iostream>
#include	<limits>

using namespace std;
 //* Definition for a point.
  struct Point {
      int x;
      int y;
      Point() : x(0), y(0) {}
      Point(int a, int b) : x(a), y(b) {}
  };
 
class Solution {
public:
	const double same_point_angle = 2147483648.0;
	static bool Point_compare(const Point a, const Point b){
		if (a.x == b.x)
			return a.y < b.y;
		else
			return a.x < b.x;
	}
	double Angle(const Point a, const Point b)
	{
		if (a.x == b.x)
		{
			return 2147483647.0;
		}
		return (double)(a.y-b.y)/(double)(a.x-b.x);
	}
	bool IsPointSame(const Point a, const Point b){
		if (a.x == b.x && a.y == b.y)
			return true;
		return false;
	}
	
public:
    int maxPoints(vector<Point> &points) {
		if(points.size() < 3)
			return (int)points.size();
		//1. The size points is larger than 2
		//2. sort all the points according to their x value
		//3. max is used to store the maximum number of the points
		int max = 2;
		sort(points.begin(), points.end(), Solution::Point_compare);
		for (unsigned i = 0; i<points.size() && i + max <= points.size(); )
		{
			map<double, int> hash;
			int same_point = 1;
			unsigned j = i;
			while (IsPointSame(points[++j], points[i]) && j<points.size()-1){
				same_point++;
			}
			if (j + 1 == points.size())
			{
				if (IsPointSame(points[j], points[i]))
				{
					same_point++;
					if (same_point > max)
						max = same_point;
					break;
				}
				
			}
			int backup = j;
			for(; j<points.size() ; j++)
			{	
				double angle = Angle(points[j], points[i]);
				hash[angle]++;
				if(hash[angle]  + same_point> max)
					max = hash[angle] + same_point;
			}
			i = backup;
		}
		return max;        
    }
};

int main()
{
	Point a(0, 0);
	Point b(-1, -1);
	Point c(0, 0);
	vector<Point> points;
	points.push_back(a);
	points.push_back(b);
	points.push_back(c);
	Solution instance;
	cout << instance.maxPoints(points) << endl;
	cout << "Hello World!" << endl;


	////numbers limits
	cout << "int: \t" << "size: " << sizeof(int);
	cout << "\tmaximum value: " << (numeric_limits<int>::max)();
	cout << "\tminimum value: " << (numeric_limits<int>::min)() << endl;
	return 0;
}
