package lee;



import lee.model.ListNode;

import java.util.List;

public class a_合并两个有序链表 {

    /**
     * merge two lists
     * 优雅递归
     * @param list1 list1
     * @param list2 list2
     * @return {@link ListNode}
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        if(list1.val< list2.val){
            list1.next =mergeTwoLists(list1.next, list2);
            return list1;
        }else {
            list2.next =mergeTwoLists(list2.next, list1);
            return list2;
        }
    }

    /**
     * merge two lists1
     * 蔗民做法
     * @param list1 list1
     * @param list2 list2
     * @return {@link ListNode}
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode help = null,head =null,save;
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        do{
            if(list1.val>list2.val){
                if(help!=null){
                    help.next = list2;
                }else {
                    head = list2;
                }
                save = list2.next;
                list2.next = list1;
                help = list2;
                list2 = save;
            } else {
                if(help!=null){
                    help.next =  list1;
                }else {
                    head = list1;
                }
                save = list1.next;
                list1.next = list2;
                help = list1;
                list1 = save;
            }
        }while (list1!=null && list2 !=null);
        return head;
    }
}
