'''
5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

'''

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        lent = len(res)
        for i in range(len(s)):
            for j in range(i, len(s)):
                temp = s[i:j+1]
                if(temp == temp[::-1]):
                    if(len(temp) > lent):
                        res = temp
                        lent = len(temp)

        return res
