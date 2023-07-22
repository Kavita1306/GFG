/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/
class Solution
{
    //Function to remove duplicates from unsorted linked list.
   public static Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        HashSet<Integer> seen = new HashSet<>();
        Node dummy = new Node(0); 
        Node current = dummy;

        while (head != null) {
            if (!seen.contains(head.data)) {
                seen.add(head.data);
                current.next = new Node(head.data);
                current = current.next;
            }
            head = head.next;
        }
        return dummy.next;
   }
}
