/*
2864. Maximum Odd Binary Number

You are given a binary string s that contains at least one '1'.
You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.
Return a string representing the maximum odd binary number that can be created from the given combination.
Note that the resulting string can have leading zeros.

Example 1:
Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".

Example 2
Input: s = "0101"
Output: "1001"
Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100". So the answer is "1001".

*/

class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder str = new StringBuilder(s);
        boolean flag = false;
        int idx = 0, i = s.length()-1;
        
        // used to track last '1'
        while(!flag) {
            if(str.charAt(i) == '1' && !flag) {
                str.setCharAt(i,'0');
                str.setCharAt(s.length()-1, '1');
                flag = !flag;
            }
            i--;
        }

        // used to make greater value by appending to start
        for(; i>=idx; i--) {
            if(str.charAt(i) == '1') {
                str.deleteCharAt(i);
                str.insert(0, '1');
                i++;
                idx++;
            }
        }

        return str.toString();
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
