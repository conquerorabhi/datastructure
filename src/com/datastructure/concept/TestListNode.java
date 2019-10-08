package com.datastructure.concept;

import java.util.List;

/**
 * Created by asingh on 7/4/19.
 */
public class TestListNode {
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        TestListNode lTest = new TestListNode();

        ListNode nodenew = new ListNode(3);
        ListNode nextNewNode = new ListNode(5);
        nodenew.next = nextNewNode;

        //ListNode rt = lTest.swapPairs(node1);
        //lTest.printList(rt);
        //lTest.printList(lTest.reverseBetween(nodenew,1,2));

        ListNode root = new ListNode(0);
        root.next = new ListNode(0);
        lTest.isPalindrome(root);
    }

    public void printList(ListNode node){
        ListNode head = node;
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }

//    public ListNode reverseList(ListNode node){
//        ListNode previous = null;
//        ListNode current = node;
//        ListNode next;
//        while(current!=null){
//            next = current.next;
//            current.next = previous;
//            previous = current;
//            current = next;
//        }
//        node = previous;
//        return node;
//    }

    public ListNode swapPairs(ListNode node){
        ListNode head = node;
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        int index = 0;
        while(current!=null && current.next!=null){
            if(index%2==0){
                next = current.next;
                current.next = next.next;
                next.next = current;
                if(prev!=null){
                    prev.next = next;
                }
                if(index==0){
                    head = next;
                }
                prev = next;
                current = next.next;
            }else{
                next = current.next;
                prev = current;
                current = next;
            }
            index++;
        }

        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }else if(m==n){
            return head;
        }

        ListNode prev = null;
        ListNode revPrev = null;
        ListNode current = head;
        ListNode result = head;
        ListNode next = null;
        ListNode nextHead = null;
        ListNode revList = null;
        ListNode revListStNode = null;
        int index = 1;
        while(current!=null){
            next = current.next;
            if(index==n){
                nextHead = next;
            }
            if(index>m && index<=n){
                if(revPrev!=null){
                    current.next = revPrev;
                    revPrev = current;
                }
                if(index==n){
                    revList = current;
                }
                current = next;
            }else{

                if(index<m){
                    prev = current;
                }else if(index==m){
                    current.next = null;
                    revListStNode = current;
                    revPrev = current;
                }
                current = next;
            }
            index = index + 1;
        }

        if(current==null){
            if(prev!=null){
                prev.next = revList;
            }else{
                result = revList;
            }

            if(nextHead!=null){
                revListStNode.next = nextHead;
            }

        }

        return result;
    }

    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode before = new ListNode(0);
        ListNode beforeHead = before;
        ListNode after = new ListNode(0);
        ListNode afterHead = after;
        ListNode next = null;
        ListNode current = head;

        while(current!=null){
            next = current.next;
            if(current.val<x){
                current.next = null;
                after.next = current;
                after = after.next;
            }else{
                current.next = null;
                before.next = current;
                before = before.next;
            }
            current = next;
        }
        afterHead = afterHead.next;
        after.next = beforeHead.next;
        return afterHead;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode list = head;
        ListNode current = head;
        ListNode revNext = null;
        ListNode next = null;
        ListNode reverseList = reverseList(list);
        ListNode revCurrent = reverseList;
        while(current!=null && revCurrent!=null){
            if(current.val!=revCurrent.val){
                return false;
            }
            next = current.next;
            revNext = revCurrent.next;

            current = next;
            revCurrent = revNext;
        }

        if(current==null && revCurrent!=null){
            return false;
        }else if(revCurrent==null && current!=null){
            return false;
        }
        return true;

    }

    private ListNode reverseList(ListNode root){
        ListNode current = root;
        ListNode prev = null;
        ListNode next = null;
        while(current!=null) {
            next = current.next;
            if(prev!=null){
                current.next = prev;
            }else{
                current.next = null;
            }
            prev = current;
            current = next;
        }
        return prev;
    }
}
