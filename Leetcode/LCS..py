'''
1143. Longest Common Subsequence
Solved
Medium
Topics
Companies
Hint
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.

'''


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if len(text1) < len(text2):
            return self.LCS(text1, text2)
        return self.LCS(text2, text1)

    def LCS(self, str1, str2):
        dp = [0] * (len(str1) + 1)

        for i in range(1, len(str2) + 1):
            prev = 0
            for j in range(1, len(str1) + 1):
                temp = dp[j]
                # print("i={0}, j={1}, prev={2}, temp={3}, str1[j-1]={4}, str2[i-1]={5}, dp[j]={6}, dp[j-1]={7}\n".format(i, j, prev, temp, str1[0:j], str2[0:i], dp[j], dp[j-1]))
                if str1[j-1] == str2[i-1]:
                    dp[j] = prev + 1
                else:
                    dp[j] = max(dp[j], dp[j-1])
                prev = temp
            # print("\n")
        
        return dp[len(str1)]