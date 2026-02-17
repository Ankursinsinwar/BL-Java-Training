package Delete_middle_node;

public class Delete_middle_node {
    public class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
    Node head;
}
    public Node head;

    public void deleteMiddleNode(){
        int l = 0;
        Node temp = this.head;
        while (temp!=null) {
            l++;
        }
        if (l==1) {
            this.head = null;
            return;
        }
        int m = l%2 == 0? 1 + (l/2) : (l+1)/2;
        Node pre = this.head;
        Node temp1 = this.head.next;
        while (m>0) {
            pre = pre.next;
            temp1 = temp1.next;
            m--;
        }
        pre = temp1.next;
        temp1.next = null;
    }
}
