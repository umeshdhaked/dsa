package commons.g_linkedlist;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class RandomPointerLLCopy {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node temp = head;

        while (temp != null) {

            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;

        while (temp != null) {

            if (temp.random != null) {
                temp.next.random = temp.random.next;
            } else {
                temp.next.random = null;
            }

            temp = temp.next.next;
        }


        Node ans = head.next;

        temp = head;
        Node newTemp = ans;

        while (temp != null) {
            temp.next = newTemp.next;

            if (newTemp.next != null) {
                newTemp.next = newTemp.next.next;
            } else {
                newTemp.next = null;
            }

            temp = temp.next;
            newTemp = newTemp.next;
        }

        return ans;
        
    }


}