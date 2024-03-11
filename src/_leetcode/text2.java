package _leetcode;

public class text2 {
    public ListNode reverseList(ListNode head){//反转列表//递归
        if (head==null||head.next==null) return head;//空链表或只有一个节点
        ListNode newhead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;


        //ListNode newhead1=null;
      //  while(head!=null){
       //     ListNode tmp=head.next;
        //    head.next=newhead1;
        //    newhead1=head;
       //     head=tmp;
       // }
    }

    //非递归

    private class ListNode{
        int val;
        text2.ListNode next;
        ListNode(int x){
            val=x;
        }
    }
}
