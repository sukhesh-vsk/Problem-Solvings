/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] pVal = new int[n];
        int [] sVal = new int[n];
        int [] result  = new int[n];
        pVal[0] = 1;
        sVal[n-1] = 1;

        for(int i=1; i<n; i++) {
            pVal[i] = nums[i-1] * pVal[i-1];
            sVal[n-i-1] = nums[n-i] * sVal[n-i];
        }

        for(int i=0; i<n; i++) {
            result[i] = pVal[i] * sVal[i];
        }

        return result;
    }
}
