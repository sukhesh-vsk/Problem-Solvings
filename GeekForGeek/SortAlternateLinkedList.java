/*
Linked List that is Sorted Alternatingly

You are given a Linked list of size n. The list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.

Example 1:
Input:
n = 6
LinkedList = 1->9->2->8->3->7

Output: 1 2 3 7 8 9

Explanation: 
After sorting the given list will be 1->2->3->7->8->9.
*/

class Solution {
    
   public Node sort(Node head){
        Node st = head;
        Node en = null;
        
        for(Node node = head.next.next; node != null; node = node.next.next) {
            Node temp = st.next;
            st.next = node;
            st = st.next;
            temp.next = en;
            en = temp;
            
            if(node.next == null) break;
        }
        
        if(st.next == null) {
            st.next = en;
        } else {
            st.next.next = en;
        }
        
        return head;
        
   }


