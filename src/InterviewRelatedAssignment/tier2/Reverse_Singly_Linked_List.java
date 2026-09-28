package InterviewRelatedAssignment.tier2;

public class Reverse_Singly_Linked_List {
    // Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Reverse the linked list
    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // Store the next node
            ListNode next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev and curr forward
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Print the linked list
    public static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list:
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original linked list:");
        printList(head);

        // Reverse the linked list
        head = reverse(head);

        System.out.println("Reversed linked list:");
        printList(head);
    }
}
