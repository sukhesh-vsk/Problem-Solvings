/*
1609. Even Odd Tree

A binary tree is named Even-Odd if it meets the following conditions:
    The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
    For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
    For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
*/

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return false;
        int lvl = 0;
        q.offer(root);

        while(!q.isEmpty()) {
            int len = q.size();
            int prev = (lvl % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
            for(int i=0; i<len; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                int num = q.poll().val;
                
                if((lvl % 2 == 0) && (num % 2 == 0 || prev >= num)) return false;
                if((lvl % 2 == 1) && (num % 2 == 1 || prev <= num)) return false;
                prev = num;
            }
            lvl++;
        }

        return true;
    }
}
