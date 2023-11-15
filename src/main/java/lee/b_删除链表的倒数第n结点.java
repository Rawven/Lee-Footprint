package lee;


import lee.model.ListNode;

public class b_删除链表的倒数第n结点 {
    /**
     * remove nth from end
     * 双指针 ———— 慢指针
     * @param head head
     * @param n    n
     * @return {@link ListNode}
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head,slow =head;
        int num = 0;
        while (fast!=null){
            if(num > n ){
                slow=slow.next;
            }
            fast=fast.next;
            num++;
        }
        if(num <= n){
            head= head.next;
        }else{
            slow.next = slow.next.next;
        }
        return head;
    }
    /**
     * remove nth from end
     * 蔗民做法
     * @param head head
     * @param n    n
     * @return {@link ListNode}
     */
    public static ListNode removeNthFromEndO( ListNode head, int n) {
        ListNode save = head,a=head;
        int index = 0;
        while (head!=null){
            head = head.next;
            index++;
        }
        index-=n;
        if(index == 0){
            return save.next;
        }
        while (a!=null&&index>1){
            a=a.next;
            index--;
        }
        if(a.next!=null){
            a.next = a.next.next;
        }
        return save;
    }
}
