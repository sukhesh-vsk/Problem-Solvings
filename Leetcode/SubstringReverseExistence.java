/*
3083. Existence of a Substring in a String and Its Reverse

Given a string s, find any substring of length 2 which is also present in the reverse of s.
Return true if such a substring exists, and false otherwise.

Example 1:
Input: s = "leetcode"
Output: true
Explanation: Substring "ee" is of length 2 which is also present in reverse(s) == "edocteel".

Example 2
Input: s = "abcba"
Output: true
Explanation: All of the substrings of length 2 "ab", "bc", "cb", "ba" are also present in reverse(s) == "abcba".


*/

class Solution {
    public boolean isSubstringPresent(String s) {
        HashMap<String , Integer> hMap = new HashMap<>();
        
        for(int i=0; i<s.length()-1; i++) {
            System.out.println(s.substring(i, i+2));
            if (hMap.containsKey(s.substring(i, i+2))) {
                return true;
            } else hMap.put(s.substring(i, i+2), 1);
            
        }
        System.out.println();
        
        for(int i=s.length()-1; i>=1; i--) {
            String temp = "";
            temp +=s.charAt(i);
            temp += s.charAt(i-1);
            System.out.println(temp);
            if (hMap.containsKey(temp)) {
                return true;
            }
        }
        
        return false;
    }
}
