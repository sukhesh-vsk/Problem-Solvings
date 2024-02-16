'''
1481. Least Number of Unique Integers after K Removals

Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

Example 1:
Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.

Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
'''

class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        count = {}
        for i in arr:
            if i in count:
                count[i] += 1
            else:
                count[i] = 1

        key = sorted(count.keys(), key=lambda x: count[x])
        cnt = 0
        for i in key:
            if k >= count[i]:
                k -= count[i]
                count[i] = 0
            else:
                count[i] -= k
                k = 0

            if count[i] != 0:
                cnt += 1
        return cnt                