package com.LeetCode.数学;

/**
 * @ClassName LeetCode_2
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/16 14:17
 * @Version 1.0
 **/
public class LeetCode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root=new ListNode(0);
        ListNode l3=root;
        int carry=0;
        while (l1!=null||l2!=null||carry!=0){
            int l1Val= l1!= null ? l1.val : 0;
            int l2Val= l2!= null ? l2.val : 0;
            int sum=l1Val+l2Val+carry;
            //进位等于sum/10
            carry=sum/10;
            //节点值等于sum%10
            ListNode cur=new ListNode(sum%10);
            l3.next=cur;
            l3=cur;

            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
        }

        return root.next;
    }
}
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
