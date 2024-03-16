/*
525. Contiguous Array

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [
*/

class Solution {
    public int findMaxLength(int[] nums) {
        int pSum = 0;
        int result = 0;
        Map<Integer, Integer> hMap = new HashMap<>();
        hMap.put(0, -1);
        for(int i=0; i<nums.length; i++) {
            pSum += (nums[i] == 0) ? -1 : 1;
            if(hMap.containsKey(pSum)) {
                result = Math.max(result, i - hMap.get(pSum));
            }else{
                hMap.put(pSum, i);
            }
        }

        return result;
    }
}
