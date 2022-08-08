package dataStructrue.linkList;

public class linkList {
    class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
        }
    }

    class doubleNode {
        public int value;
        public doubleNode pre;
        public doubleNode next;

        public doubleNode(int value, doubleNode pre, doubleNode next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public doubleNode() {
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static doubleNode reverseDoubleList(doubleNode head) {
        doubleNode pre = null;
        doubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 合并两个单链表，并按照从小到大的顺序排列
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeTwoLists(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.value <= head2.value ? head1 : head2;
        Node cur1 = head.next;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
