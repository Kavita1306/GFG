/*
 
  Node is defined as
  struct Node {
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/
class Solution
{
    public:
    //Function to sort a linked list of 0s, 1s and 2s.
    Node* segregate(Node* head) {
    if (!head || !head->next) {
        return head;
    }

    Node* zeroHead = nullptr; // Pointer for 0s list
    Node* oneHead = nullptr;  // Pointer for 1s list
    Node* twoHead = nullptr;  // Pointer for 2s list

    Node* zeroTail = nullptr; // Tail pointer for 0s list
    Node* oneTail = nullptr;  // Tail pointer for 1s list
    Node* twoTail = nullptr;  // Tail pointer for 2s list

    while (head) {
        if (head->data == 0) {
            if (!zeroHead) {
                zeroHead = zeroTail = head;
            } else {
                zeroTail->next = head;
                zeroTail = zeroTail->next;
            }
        } else if (head->data == 1) {
            if (!oneHead) {
                oneHead = oneTail = head;
            } else {
                oneTail->next = head;
                oneTail = oneTail->next;
            }
        } else { // head->data == 2
            if (!twoHead) {
                twoHead = twoTail = head;
            } else {
                twoTail->next = head;
                twoTail = twoTail->next;
            }
        }

        head = head->next;
    }

    // Connect the lists together
    if (zeroTail) {
        zeroTail->next = oneHead ? oneHead : twoHead;
    }
    if (oneTail) {
        oneTail->next = twoHead;
    }
    if (twoTail) {
        twoTail->next = nullptr;
    }

    // Return the head of the newly segregated list
    return zeroHead ? zeroHead : (oneHead ? oneHead : twoHead);
}
};
