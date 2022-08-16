package dataStructrue.linkList;

public class linkList {
    static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int i) {
            this.value = i;
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

    /**
     * 合并两个单链表更优版
     * @param list1
     * @param list2
     * @return
     */
    public static Node mergeTwoLists2(Node list1,Node list2){
        if(list1 == null || list2 == null){
            return list1==null?list2:list1;
        }
        Node prehead = new Node(-1);
        Node pre = prehead;
        while(list1!=null && list2 !=null){
            if(list1.value <=list2.value){
                pre.next = list1;
                list1=list1.next;
            }else{
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null?list2:list1;
        return prehead.next;
    }

    /**
     * 两两交换链表中相邻的节点，并返回交换后链表的头节点。（迭代）
     * @param head
     * @return
     */
    public static Node swapPairs(Node head) {
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            Node node1 = temp.next;
            Node node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    /**
     * 两两交换链表中相邻的节点，并返回交换后链表的头节点。（递归）
     * @param head
     * @return
     */
    public static Node swapPairs2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }



    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node node = swapPairs2(node1);
        while (node !=null){
            System.out.println(node.value);
            node=node.next;
        }
    }
}
