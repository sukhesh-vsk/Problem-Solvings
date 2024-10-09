/*
34. Find First and Last Position of Element in Sorted Array.

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]


*/

//CPP 
#include <iostream>

using namespace std;

int binsearch(int*, int, int, int, bool);

int main() {
    int n;
    cin >> n;
    int books[n];
    for(int i=0; i<n; i++)
        cin >> books[i];
    int key;
    cin >> key;
    
    int st = binsearch(books, key, 0, n-1, false);
    
    if(st==-1) {
        cout << "NO OCCURRENCES";
        return 0;
    }
    
    int en = binsearch(books, key, st+1, n-1, true);
    cout << st << " " << ((en == -1) ? st : en);
}

int binsearch(int* arr, int key, int st, int en, bool isEND) {
  if(isEND) cout << "Hello\n";
    if(st>en) return -1;
    int mid = st + (en-st)/2;
    if(arr[mid] == key){
      int next;
      if (isEND)
        next = binsearch(arr, key, mid+1, en, isEND);
      else
        next = binsearch(arr, key, st, mid-1, isEND);
      return (next != -1) ? next : mid;
    }
    
    if(arr[mid] < key)
        return binsearch(arr, key, mid+1, en, isEND);
    return binsearch(arr, key, st, mid-1, isEND);
}

// JAVA
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = leftOccurance(nums, 0, nums.length-1, target);
        
        if(first == -1) return new int [] {-1, -1};
        
        int last = lastOccurance(nums, first, nums.length-1, target);
        
        return new int [] {first, last};
    }

    public int leftOccurance(int [] nums, int st, int en, int key) {
        int first = -1;
        while(st<=en) {
            int mid = (st + en) / 2;

            if(nums[mid] == key) {
                first = mid;
                en = mid-1;
            }
            else if(nums[mid] > key) en = mid-1;
            else st = mid+1;
        }

        return first;
    }

    public int lastOccurance(int [] nums, int st, int en, int key) {
        int last = -1;
        while(st<=en) {
            int mid = (st + en) / 2;

            if(nums[mid] == key) {
                last = mid;
                st = mid+1;
            }
            else if(nums[mid] > key) en = mid-1;
            else st = mid+1;
        }

        return last;
    }
}
