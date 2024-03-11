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
