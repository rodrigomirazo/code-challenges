package com.code.challenges.divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKLists {

    static ListNode mergedList = null;

    static void main() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(6);

        System.out.println(list1);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode list3 = new ListNode(0);
        list3.next = new ListNode(9);

        ListNode[] lists = new ListNode[]{list1, list2, list3};

        mergeKLists(lists);

        System.out.println(mergedList);
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        // iterate each List
        int count = 0;

        List<Integer> countEmptyLists = new ArrayList<>();
        while(countEmptyLists.size() != lists.length) {

            for(int i = 0; i < lists.length; i++) {

                // Validate list is not empty -> Keep track of wich List is empty
                if(lists[i] == null) {
                    if(!countEmptyLists.contains(i)) {
                        countEmptyLists.add(i);
                    }
                } else {

                    // if 'val' == count
                    // then: add(count) into linked List
                    // then: iterate through merged List
                    // lists[i] will remain the same\

                    if(lists[i].val == count) {

                        if(mergedList == null) {
                            mergedList = new ListNode(count);
                        } else {
                            mergedList.next = new ListNode(count);
                            mergedList = mergedList.next;
                        }
                        System.out.println(" " + count);
                        lists[i] = lists[i].next;
                    }
                }
            }
            count++;
        }
        return mergedList;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
