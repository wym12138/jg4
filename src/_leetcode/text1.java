package _leetcode;

public class text1 {//删除节点

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
    public void deleteNode(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;

    }
}
