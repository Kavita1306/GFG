class Solution
{
      public static Node reverse(Node head, int k) {
        Node current = head;
        Node prevTail = null;
        boolean firstGroup = true;
        while (current != null) {
            Node groupStart = current;
            Node prev = null;
            int count = 0;
            while (current != null && count < k) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
                count++;
            }
            if (firstGroup) {
                head = prev;
                firstGroup = false;
            } else {
                prevTail.next = prev;
            }
            prevTail = groupStart;
        }
        return head;}
}
