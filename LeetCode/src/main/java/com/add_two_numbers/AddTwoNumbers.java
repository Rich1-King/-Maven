package com.add_two_numbers;

/**
 * Created by rich1 on 6/12/17.
 */
public class AddTwoNumbers{

    public static void main(String[] args){

        ListNode nodeA1 = new ListNode(2);
        ListNode nodeA2 = new ListNode(4);
        ListNode nodeA3 = new ListNode(3);

        ListNode nodeB1 = new ListNode(5);
        ListNode nodeB2 = new ListNode(6);
        ListNode nodeB3 = new ListNode(4);

        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;

        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        addTwoNumbers(nodeA1, nodeB1);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode retNode = new ListNode(0);
        ListNode headNode = retNode;
        while(null != l1 || null != l2){
            ListNode node = new ListNode(0);
            if(null != l1 && null != l2 && l1.val + l2.val >= 10){
                int value = (l1.val + l2.val)%10;
                retNode.val = retNode.val + value;
                node.val = node.val + 1;
                retNode.next = node;
            }else if(null == l1 || null == l2){
                ListNode nodeL = null;
                if(l1 != null){
                    nodeL = l1;
                }

                if(l2 != null){
                    nodeL = l2;
                }

                if(nodeL == null){
                    continue;
                }

                retNode.val = retNode.val + nodeL.val;
                if(null == l1.next || null == l2.next){

                }else{
                    retNode.next = node;
                }
            }else{
                int value = (l1.val + l2.val)%10;
                retNode.val = retNode.val + value;
                if(null == l1.next || null == l2.next){

                }else{
                    retNode.next = node;
                }
            }
            retNode = retNode.next;
            if(null != l1){
                l1 = l1.next;
            }
            if(null != l2){
                l2 = l2.next;
            }
        }

        return headNode;
    }

}
