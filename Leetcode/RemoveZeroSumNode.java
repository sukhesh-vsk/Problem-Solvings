/*
1171. Remove Zero Sum Consecutive Nodes from Linked List

Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]
*/


class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> hMap = new HashMap<>();
        int pSum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        hMap.put(0, dummy);
        
        while(head != null) {
            pSum += head.val;
            if(hMap.containsKey(pSum)) {
                int sum = pSum;
                ListNode temp = hMap.get(pSum).next;
                while(temp != head) {
                    sum += temp.val;
                    hMap.remove(sum);
                    temp = temp.next;
                }
                hMap.get(pSum).next = head.next;
            } else {
                hMap.put(pSum, head);
            }
            head = head.next;
        }

        return dummy.next;
    }
}
