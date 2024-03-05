/*
948. Bag of Tokens

You start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer array tokens, where each tokens[i] donates the value of tokeni.

Your goal is to maximize the total score by strategically playing these tokens. In one move, you can play an unplayed token in one of the two ways (but not both for the same token):

Face-up: If your current power is at least tokens[i], you may play tokeni, losing tokens[i] power and gaining 1 score.
Face-down: If your current score is at least 1, you may play tokeni, gaining tokens[i] power and losing 1 score.
Return the maximum possible score you can achieve after playing any number of tokens.

Example :

Input: tokens = [100,200,300,400], power = 200
Output: 2

Explanation: Play the tokens in this order to get a score of 2:
Play token0 (100) face-up, reducing power to 100 and increasing score to 1.
Play token3 (400) face-down, increasing power to 500 and reducing score to 0.
Play token1 (200) face-up, reducing power to 300 and increasing score to 1.
Play token2 (300) face-up, reducing power to 0 and increasing score to 2.
The maximum score achievable is 2.
*/

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int max_score = 0;
        Arrays.sort(tokens);
        int st = 0, en = tokens.length-1;
        int score = 0;
        while(st<=en) {
            if(power >= tokens[st]) {
                power -= tokens[st];
                score++;
                st++;
                max_score = Math.max(score, max_score);
            } else if(score > 0){
                power += tokens[en];
                score--;
                en--;
            }else break;
        }

        return max_score;
    }
}
