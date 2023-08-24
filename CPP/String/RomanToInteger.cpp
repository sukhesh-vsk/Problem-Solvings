/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3

Example 2:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4
*/

class Solution {
public:
    int precedence(char ch){
        switch(ch){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    int romanToInt(string s){
        int num = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int val = precedence((char)s[i]);
            int temp = 0;
            if(i<n){
                temp = precedence((char)s[i+1]);
                if(temp>val){
                    num += (temp-val);
                    i++;
                }
                else{
                    num += val;
                }
            }
            else{
                num += val;
            }
        }
        return num;
    }
};
